package com.playtalk.playtalkapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="community")
public class Community {
    @Id
    @Column(name="comm_id")
    private int comm_id;
    @Column(name="user_id",nullable=false)
    private String user_id;
    @Column(name="title",nullable=false)
    private String title;
    @Column(name="content",nullable=false)
    private String content;
    @Column(name="view_count",nullable=false)
    private int view_count;
    @Column(name="post_time",nullable=false)
    private LocalDateTime post_time;

}
