package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String user_id;
    @Column(name="pw",nullable=false)//null을 허용하지 않는다.
    private String pw;
    private String nkname;
    private String email;
    private String phone_number;
    @CreationTimestamp
    private LocalDateTime signup_date;
    private String email_check_code;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // 클래스간의 양방향관계. 관계 주인(외래키 관리 주인)이 아닌 엔티티 클래스명 -> mappedBy = 엔티티 클래스명 // getNoticeList 할때 조인 (조회할때 조인 _ 지연로딩)
    private List<Notice> noticeList;

    private String email_check_code;


    //만약에 autoIncrement가 있는 컬럼인경우
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int index;

}

