package com.playtalk.playtalkapp.dto.assign;

import com.playtalk.playtalkapp.dto.user.CommunityDto;
import lombok.Data;

@Data
public class CommImgsDto {
  private Long imgId;
  private String imgPath;
  private String imgMain;
  private CommunityDto community;
}
