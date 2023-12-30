package com.playtalk.playtalkapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Long commId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "INT UNSIGNED DEFAULT 0")
    private Long viewCount;

    @CreationTimestamp
    private LocalDateTime postTime;

    @Enumerated(EnumType.STRING)
    private CommCategory category = CommCategory.잡담;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "community",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommReplies> commReplies;

    @OneToMany(mappedBy = "community",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommImgs> commImgs;

}