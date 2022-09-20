package com.workspaceit.socialmediaproject.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "reaction_table")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // reaction 1 for upvote and 0 for downvote
    @NotNull
    private int reaction;

}
