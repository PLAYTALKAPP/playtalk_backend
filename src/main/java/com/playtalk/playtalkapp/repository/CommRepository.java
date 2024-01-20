package com.playtalk.playtalkapp.repository;

import com.playtalk.playtalkapp.domain.Community;
import com.playtalk.playtalkapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommRepository extends JpaRepository <Community,Long> {
//    리스트
    List<Community> findAll();


//    List<Community> findByUserId(Long userId);
//    //"SELECT c FROM Community c WHERE c.user.id = :userId"


//    Community findByCommId();



}
