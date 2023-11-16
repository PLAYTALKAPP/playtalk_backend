package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "assign_reply")
public class AssignReply {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "assign_reply_id")
  private Long assign_reply_id;

  @CreationTimestamp
  private LocalDateTime post_time;

  @OneToOne
  @JoinColumn(mappedBy = "user")
  private User user;

  @ManyToOne
  @JoinColumn(name = "assign_id")
  private Assign assign;

}
