package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comm_reply_img")
public class CommReplyImg {

    @Id
    @Column(name="comm_reply_img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comm_reply_img_id;

    @Column(name = "comm_reply_id", nullable = false)
    private int comm_reply_id;

    @Column(name = "img_path")
    private String img_path;

    @Column(name = "img_main")
    private Boolean img_main;

    @ManyToOne
    @JoinColumn(name = "comm_reply_id")
    private CommReplies commReplies;

}
