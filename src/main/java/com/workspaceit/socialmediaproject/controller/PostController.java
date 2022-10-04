package com.workspaceit.socialmediaproject.controller;

import com.workspaceit.socialmediaproject.entity.Post;
import com.workspaceit.socialmediaproject.wrapper.PostsWrapper;
import com.workspaceit.socialmediaproject.wrapper.ReactNumberWrapper;
import com.workspaceit.socialmediaproject.entity.Reaction;
import com.workspaceit.socialmediaproject.service.CommentService;
import com.workspaceit.socialmediaproject.service.FriendsService;
import com.workspaceit.socialmediaproject.service.PostService;
import com.workspaceit.socialmediaproject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/post/{userId}")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private FriendsService friendsService;
    @Autowired
    private RequestService requestService;

    @GetMapping("/createpost")
    public ModelAndView createPost(@PathVariable int userId){
        ModelAndView postView= new ModelAndView();
        postView.setViewName("createpost");
        postView.addObject("userId",userId);
        return postView;
    }
    @PostMapping("/submit")
    public ResponseEntity submitPost( Post post,@PathVariable int userId ){

//        if(postService.postUserExists(userId)){
//            postService.addPost(post, userId);
//            return new ModelAndView("redirect:"+"http://localhost:9090/post/"+userId+"/posts/"+userId);
//        }else{
//            return new ModelAndView("error").addObject("errorMessage","User not found");
//        }
        if(postService.postUserExists(userId)){
            postService.addPost(post, userId);
            return  ResponseEntity.status(200).body("Post Created");
        }else{
            return ResponseEntity.status(400).body("User does not exist");
        }

    }

    @GetMapping("/posts/{viewerId}")
    public PostsWrapper viewPosts(@PathVariable int userId, @PathVariable int viewerId){
//        ModelAndView allPostsByUser= new ModelAndView();
//        allPostsByUser.setViewName("posts");
//        allPostsByUser.addObject("requestExists",requestService.requestExists(viewerId,userId));
//        if(userId==viewerId){
//            allPostsByUser.addObject("isOwnProfile",true);
//        }else allPostsByUser.addObject("isOwnProfile",false);
//        if(friendsService.isUserFriend(userId,viewerId)){
//
//            //list of users who are mapped as friends and who are mapped as users to this userId on friends table
//            allPostsByUser.addObject("friendsList",friendsService.getFriends(userId));
//        }
//        allPostsByUser.addObject("isFriend", friendsService.isUserFriend(userId,viewerId));
//        allPostsByUser.addObject("allPosts", postService.getAllPostsFromUser(userId));
//        allPostsByUser.addObject("userId",userId);
//        allPostsByUser.addObject("viewerId",viewerId);

        PostsWrapper postsWrapper= new PostsWrapper();
        postsWrapper.setRequestExists(requestService.requestExists(viewerId,userId));
        if(userId==viewerId){
            postsWrapper.setOwnProfile(true);
        }else postsWrapper.setOwnProfile(false);
        if(friendsService.isUserFriend(userId,viewerId)){

            //list of users who are mapped as friends and who are mapped as users to this userId on friends table
            postsWrapper.setFriendsList(friendsService.getFriends(userId));
        }
        postsWrapper.setViewerId(viewerId);
        postsWrapper.setFriend(friendsService.isUserFriend(userId,viewerId));
        postsWrapper.setUserId(userId);
        postsWrapper.setAllPosts(postService.getAllPostsFromUser(userId));
        return postsWrapper;
    }

    @GetMapping("/viewUserProfile")
    public ResponseEntity getSelectedUserPost(@PathVariable("userId") int userId,int selectedUserId){
//        ModelAndView postView= new ModelAndView("redirect:" +"http://localhost:9090/post/"+selectedUserId+"/posts/"+userId);
//        return postView;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:9090/post/"+selectedUserId+"/posts/"+userId);
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

    @GetMapping("/{postId}/reactNumber")
    public ReactNumberWrapper getNumberOfReacts(@PathVariable int postId){

//            ModelAndView reactNumber=new ModelAndView();
//            reactNumber.addObject("numberOfReacts",postService.getNumberOfReacts(postId));
//            return reactNumber;

        ReactNumberWrapper reactNumberWrapper = new ReactNumberWrapper();
        reactNumberWrapper.setNumberOfReacts(postService.getNumberOfReacts(postId));
        return reactNumberWrapper;
    }
    @GetMapping("/{postId}/getUpvotes")
    public List<Reaction> getNumberOfUpvotes(@PathVariable int postId){

        return postService.getNumberOfUpvotes(postId);
    }
}
