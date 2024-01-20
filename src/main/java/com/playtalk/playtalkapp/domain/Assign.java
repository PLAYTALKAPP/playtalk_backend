package com.playtalk.playtalkapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Assign {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long assignId;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String playArea;

  @Column(nullable = false)
  private Timestamp playDate;


  @Column(nullable = false)
  private String seatGrade;

  @Column(nullable = false)
  private String seat;

  @Column(nullable = false)
  private String cast;

  @Column(nullable = false)
  private String saleCode;

  @Column(nullable = false)
  private Integer price;

  private String etc;

  @Column(nullable = false)
  private Boolean assignYN;

  @CreationTimestamp
  private LocalDateTime postTime;

  private String imgPath;

  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "assign", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
  private List<AssignReply> assignReplyList;
}