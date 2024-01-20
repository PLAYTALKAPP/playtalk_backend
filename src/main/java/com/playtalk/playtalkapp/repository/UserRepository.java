package com.playtalk.playtalkapp.repository;


import com.playtalk.playtalkapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    User  save (User user);// 가입
//    Optional<User> findByUser (Long userId);//유저 찾기
//    Optional<User> findByName(String name); //이름찾기


    List<User> findAll(); //전체 리스트 출력
//    List<User> findByCommId(Long userId);

}

