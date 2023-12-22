package com.playtalk.playtalkapp.dto;

import lombok.Data;

@Data
public class CommRepliesImgDto {
    private  Long commReplyImgId;
    private String imgPath;
    private boolean imgMain;
    private CommRepliesDto commReplies;
}
