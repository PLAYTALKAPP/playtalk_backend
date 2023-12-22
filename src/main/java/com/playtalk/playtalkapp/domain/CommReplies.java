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
public class CommReplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commReplyId;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    private LocalDateTime postTime;

    private int parentCrId;

    @ManyToOne
    @JoinColumn(name = "commId")
    private Community community;

    @OneToMany(mappedBy = "commReplies", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommReplyImg> commReplyImg ;
}
