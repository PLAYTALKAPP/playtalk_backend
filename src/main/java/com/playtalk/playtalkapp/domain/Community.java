package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @Column(name="view_count",columnDefinition = "INT UNSIGNED DEFAULT 0")
    private int view_count;
    @Column(name="post_time",nullable=false)
    private LocalDateTime post_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "comm_reply_id") // "user"는 Post 엔티티의 user 필드와 연결
    private List<CommReplies> commReplies;

    @OneToMany(mappedBy = "comm_img_id") // "user"는 Post 엔티티의 user 필드와 연결
    private List<CommImgs> commImgs ;

}
