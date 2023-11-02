package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "assign")
public class Assign {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "assign_id", nullable = false)
  private Long assignId;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "play_area", nullable = false)
  private String playArea;

  @Column(name = "play_date", nullable = false)
  private Timestamp playDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "seat_grade", nullable = false)
  private SeatGrade seatGrade;

  @Column(name = "seat", nullable = false)
  private String seat;

  @Column(name = "cast", nullable = false)
  private String cast;

  @Column(name = "sale_code", nullable = false)
  private String saleCode;

  @Column(name = "price", nullable = false)
  private Integer price;

  @Column(name = "etc", nullable = false)
  private String etc;

  @Column(name = "assign_YN", nullable = false)
  private Boolean assignYN;

  @Column(name = "post_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp postTime;

  @Column(name = "img_path")
  private String imgPath;

  public enum SeatGrade {
    VIP,
    R,
    S,
    A
  }

  // getters and setters...
}