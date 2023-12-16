package com.playtalk.playtalkapp.dto.user;

import lombok.Data;

@Data
public class NoticeImgDto {
    private Long imgId;
    private String imgPath;
    private boolean imgMain;
    private NoticeDto notice;
}
