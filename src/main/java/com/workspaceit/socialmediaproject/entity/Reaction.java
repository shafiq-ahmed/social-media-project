package com.workspaceit.socialmediaproject.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "reaction_table")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // reaction 1 for upvote, 2 for downvote and 0 for none
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private UserReact userReact;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserReact getUserReact() {
        return userReact;
    }

    public void setUserReact(UserReact userReact) {
        this.userReact = userReact;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
