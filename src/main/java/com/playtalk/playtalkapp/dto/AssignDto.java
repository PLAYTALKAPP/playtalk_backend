package com.playtalk.playtalkapp.dto;

import lombok.Data;

@Data
public class AssignDto {
  private Long assignId;
  private String title;
  private String playArea;
  private String playDate;
  private String seatGrade;
  private String seat;
  private String cast;
  private String saleCode;
  private Integer price;
  private String etc;
  private Boolean assignYN;
  private String postTime;
  private String imgPath;
}
