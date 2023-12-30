package com.playtalk.playtalkapp.controller;


import com.playtalk.playtalkapp.domain.User;
import com.playtalk.playtalkapp.dto.UserDto;
import com.playtalk.playtalkapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/api/user")
    public ResponseEntity<List<UserDto>>list (){
//        List<User> userList = userService.list();
        List<UserDto> userList = userService.list();

        return ResponseEntity.ok().body(userList);
    }

//    @GetMapping("/")
//    public String list (Model model){
//        List<UserDto> userList = userService.list();
//        System.out.println("유저리스트 출력 ="+userList);
//        model.addAttribute("users",userList);
//        return "/";
//    }
}
