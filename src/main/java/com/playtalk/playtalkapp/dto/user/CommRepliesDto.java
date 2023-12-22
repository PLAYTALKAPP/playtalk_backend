package com.playtalk.playtalkapp.dto.user;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommRepliesDto {
    private Long commReplyId;
    private String content;
    private LocalDateTime postTime;
    private Long parentCrId;
    private CommunityDto community;
    private List<CommRepliesImgDto> commReplies;
}
