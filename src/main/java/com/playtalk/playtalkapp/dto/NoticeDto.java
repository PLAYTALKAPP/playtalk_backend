package com.playtalk.playtalkapp.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NoticeDto {
    private Long noticeId;
    private String title;
    private String content;
    private Long viewCount;
    private LocalDateTime postTime;
    private UserDto user;
    private List<NoticeImgDto> noticeImgs;
}
