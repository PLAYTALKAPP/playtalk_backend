package com.playtalk.playtalkapp.dto;

import lombok.Data;

@Data
public class AssignReplyDto {
  private Long assignReplyId;
  private String postTime;
  private UserDto user;
  private AssignDto assign;
}
