package com.playtalk.playtalkapp.service;

import com.playtalk.playtalkapp.domain.Community;
import com.playtalk.playtalkapp.domain.User;
import com.playtalk.playtalkapp.dto.CommunityDto;
import com.playtalk.playtalkapp.dto.UserDto;
import com.playtalk.playtalkapp.repository.CommRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommService {

    @Autowired
    CommRepository commRepository;

    @Autowired
    UserService userService;

    public List<CommunityDto> list(){
        List<Community> commList = commRepository.findAll();

        return commList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    //CommunityEntity -> CommunityDto 변환
    private CommunityDto convertToDto(Community community){
        CommunityDto commDto = new CommunityDto();
        commDto.setCommId(community.getCommId());
        commDto.setTitle(community.getTitle());
        commDto.setContent(community.getContent());
        commDto.setViewCount(community.getViewCount());
        commDto.setPostTime(community.getPostTime());
        commDto.setCategory(community.getCategory());
        User user = community.getUser();
        UserDto userDto = userService.getUserDto(user);
        commDto.setUser(userDto);
        return commDto;
    }


}
