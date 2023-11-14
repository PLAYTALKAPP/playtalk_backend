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
    private Long img_id;
    @Column(nullable = false)
    private String img_path;
    private boolean img_main;
    @ManyToOne // notice_img 입장에서 notice_img : notice (다대일)
    @JoinColumn(name = "notice_id") // 어떤 notice 의 img 인지 알아야 하기 때문에
    private Notice notice;
}
