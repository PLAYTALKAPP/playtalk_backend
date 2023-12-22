package com.playtalk.playtalkapp.dto;

import com.playtalk.playtalkapp.domain.GradeType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {
    private String userId;
    private String pw;
    private String nkname;
    private String email;
    private String phoneNumber;
    private LocalDateTime signupDate;
    private GradeType grade = GradeType.User;
    private String emailCheckCode;
    private List<AssignDto> assings;
    private AssignReplyDto assignReply;
    private List<ChatRoomDto> chatRoomList;
    private List<CommunityDto> communityList;
    private List<NoticeDto> noticeList;

}
