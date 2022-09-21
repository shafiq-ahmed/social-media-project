package com.workspaceit.socialmediaproject.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "reaction_table")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // reaction 1 for upvote and 0 for downvote
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private UserReact userReact;

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
}
