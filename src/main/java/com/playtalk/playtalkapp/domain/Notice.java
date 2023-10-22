package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notice_id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(columnDefinition = "INT UNSIGNED DEFAULT 0")
    private Long view_count;
    @CreationTimestamp
    private LocalDateTime post_time;

    // notice 입장에서 notice : user (다대일)
    @ManyToOne
    @JoinColumn(name = "user_id") // user_id 라는 이름으로 todo 테이블에 필드 생성
    private User user;
}
