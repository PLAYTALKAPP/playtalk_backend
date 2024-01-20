package com.playtalk.playtalkapp.service;


import com.playtalk.playtalkapp.domain.User;
import com.playtalk.playtalkapp.dto.UserDto;
import com.playtalk.playtalkapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService  {

    @Autowired
    private UserRepository userRepository;

//    public List<User> list(){
//        List<User> userList = userRepository.findAll();
//        return userList;
//    }

    public List<UserDto> list() {
        List<User> userList = userRepository.findAll();

        // Java 8+의 Stream API를 활용하여 간결하게 코드 작성
        return userList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {
        // User 엔터티를 UserDto로 변환
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setNkname(user.getNkname());
        // 다른 필드들도 필요한 경우 추가
        return userDto;
    }

    public  UserDto getUserDto(User user) {
        return convertToDto(user);
    }
}
