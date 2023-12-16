package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(columnDefinition = "INT UNSIGNED DEFAULT 0")
    private Long viewCount;
    @CreationTimestamp
    private LocalDateTime postTime;
    @ManyToOne // notice 입장에서 notice : user (다대일)
    @JoinColumn(name = "user_id") // user_id 라는 이름으로 todo 테이블에 필드 생성
    private User user;
    @OneToMany(mappedBy = "notice",cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private List<NoticeImg> noticeImgs;
}

// 만약 양방향 관계를 설정하고 싶지 않거나, 한 쪽 엔티티에서 다른 쪽 엔티티를 참조하는 것이 불필요한 경우,
// 비주인 엔티티에서는 해당 관계 필드를 정의할 필요가 없습니다.
// 주인 엔티티에서만 관계 필드를 정의하고 mappedBy 속성을 사용하여 양방향 관계를 설정하면 됩니다.