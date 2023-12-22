package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommReplyImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commReplyImgId;


    @Column(nullable = false)
    private String imgPath;

    private boolean imgMain;

    @ManyToOne
    @JoinColumn(name = "commReplyId", insertable = false, updatable = false)
    private CommReplies commReplies;
}
