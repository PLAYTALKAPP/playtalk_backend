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
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comm_id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(columnDefinition = "INT UNSIGNED DEFAULT 0")
    private Long view_count;
    @CreationTimestamp
    private LocalDateTime post_time;
    @Enumerated(EnumType.STRING)
    private CommCategory category = CommCategory.잡담;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "community",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommReplies> commReplies;
    @OneToMany(mappedBy = "community",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommImgs> commImgs;

}