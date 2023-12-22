package com.playtalk.playtalkapp.dto;

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
