package com.playtalk.playtalkapp.repository;

import com.playtalk.playtalkapp.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommRepository extends JpaRepository <Community,Long> {
//    리스트
    List<Community> findAll();
}
