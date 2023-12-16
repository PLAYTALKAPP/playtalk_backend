package com.playtalk.playtalkapp.dto.user;

import com.playtalk.playtalkapp.domain.CommCategory;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommunityDto {
    private Long commId;
    private String title;
    private String content;
    private Long viewCount;
    private LocalDateTime postTime;
    private CommCategory category;
    private UserDto user;
    private List<CommRepliesDto> commReplies;
    private List<CommImgsDto> commImgs;
}
