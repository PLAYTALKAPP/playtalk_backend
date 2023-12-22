package com.playtalk.playtalkapp.dto.assign;

import com.playtalk.playtalkapp.dto.user.UserDto;
import lombok.Data;

@Data
public class AssignReplyDto {
  private Long assignReplyId;
  private String postTime;
  private UserDto user;
  private AssignDto assign;
}
