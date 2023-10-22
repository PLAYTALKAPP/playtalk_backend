package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notice_img_id;
    @Column(nullable = false)
    private String img_path;

    // notice_img 입장에서 notice_img : notice (다대일)
    @ManyToOne
    @JoinColumn(name = "notice_id")
    private Notice notice;
}
