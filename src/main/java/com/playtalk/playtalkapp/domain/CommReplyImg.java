package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comm_imgs")
public class CommReplyImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comm_reply_img_id;
    @Column(nullable = false)
    private String img_path;
    private boolean img_main;


    @ManyToOne
    @JoinColumn(name = "comm_reply_id", insertable = false, updatable = false)
    private CommReplies commReplies;

}
