package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="community")
public class Community {
    @Id
    @Column(name="comm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "comm_reply_id")
    private List<CommReplies> commReplies;

    @OneToMany(mappedBy = "comm_img_id")
    private List<CommImgs> commImgs ;

}
