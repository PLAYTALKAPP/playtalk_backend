package com.playtalk.playtalkapp.controller;


import com.playtalk.playtalkapp.dto.CommunityDto;
import com.playtalk.playtalkapp.service.CommService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommController {

    private final CommService commService;

    @GetMapping("/comm/list")
    public ResponseEntity<List<CommunityDto>> list() {
        List<CommunityDto> communityList = commService.list();
        return ResponseEntity.ok().body(communityList);
    }

}
