package com.playtalk.playtalkapp.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ChatRoomDto {
  private Long crId;
  private List<ChatMessageDto> chatMessages;
  private UserDto user;
  private LocalDate createTime;
  private LocalDate updateTime;
}
