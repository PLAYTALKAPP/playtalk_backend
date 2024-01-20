package com.playtalk.playtalkapp.service;

import com.playtalk.playtalkapp.dto.CommunityDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommServiceTest {

    @Autowired
    CommService commService;

    @Test
    void list(){
        List<CommunityDto> comlist = commService.list();
        System.out.println(comlist);
    }
}