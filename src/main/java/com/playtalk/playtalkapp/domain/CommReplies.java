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
@Table(name="comm_replies")
public class CommReplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comm_reply_id;
    @Column(nullable = false)
    private String content;
    @CreationTimestamp
    private LocalDateTime post_time;
    private int parent_cr_id;

    @ManyToOne
    @JoinColumn(name = "comm_id")
    private Community community;

    @OneToMany(mappedBy = "commReplies", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommReplyImg> commReplyImg ;
}
