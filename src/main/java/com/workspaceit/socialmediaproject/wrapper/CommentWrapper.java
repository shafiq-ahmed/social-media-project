package com.workspaceit.socialmediaproject.wrapper;

import com.workspaceit.socialmediaproject.entity.Comment;

import java.util.List;

public class CommentWrapper {
    private int userId;
    private String comment;
    private int postId;
    private List<Comment> commentList;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
