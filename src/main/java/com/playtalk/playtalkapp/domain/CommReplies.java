package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="comm_replies")
public class CommReplies {

    @Id
    @Column(name="comm_reply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comm_reply_id;

    @Column(name="comm_id",nullable=false)
    private int comm_id;

    @Column(name="user_id",nullable=false)
    private String user_id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name="post_time",nullable=false)
    private LocalDateTime post_time;

    @Column(name="parent_cr_id")
    private int parent_cr_id;

}
