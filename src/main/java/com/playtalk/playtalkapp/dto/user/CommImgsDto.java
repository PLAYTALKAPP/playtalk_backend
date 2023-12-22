package com.playtalk.playtalkapp.dto.user;

import lombok.Data;

@Data
public class CommImgsDto {
    private Long imgId;
    private String imgPath;
    private boolean imgMain;

    private CommunityDto communityDto;
}
