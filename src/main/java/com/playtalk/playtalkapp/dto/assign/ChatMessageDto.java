package com.playtalk.playtalkapp.dto.assign;

import com.playtalk.playtalkapp.dto.user.UserDto;
import lombok.Data;

@Data
public class ChatMessageDto {
private Long cmId;
  private String content;
  private String postTime;
  private String messageType;
  private ChatRoomDto chatRoom;
  private UserDto sender;
}
