package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assign")
public class Assign {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "assign_id", nullable = false)
  private Long assign_id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "play_area", nullable = false)
  private String play_area;

  @Column(name = "play_date", nullable = false)
  private Timestamp play_date;

  @Enumerated(EnumType.STRING)
  @Column(name = "seat_grade", nullable = false)
  private String seat_grade;

  @Column(name = "seat", nullable = false)
  private String seat;

  @Column(name = "cast", nullable = false)
  private String cast;

  @Column(name = "sale_code", nullable = false)
  private String sale_code;

  @Column(name = "price", nullable = false)
  private Integer price;

  @Column(name = "etc")
  private String etc;

  @Column(name = "assign_YN", nullable = false)
  private Boolean assign_YN;

  @CreationTimestamp
  private LocalDateTime post_time;

  @Column(name = "img_path")
  private String img_path;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "assign", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
  private List<AssignReply> assignReplyList;
}