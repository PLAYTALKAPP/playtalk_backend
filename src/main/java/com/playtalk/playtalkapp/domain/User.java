package com.playtalk.playtalkapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column
    private String userId;
    @Column(name="pw",nullable=false)//null을 허용하지 않는다.
    private String pw;
    private String nkname;
    private String email;
    private String phoneNumber;
    @CreationTimestamp
    private LocalDateTime signupDate;
    @Enumerated(EnumType.STRING)
    private GradeType grade = GradeType.User;
    private String emailCheckCode;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Assign> assigns;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AssignReply> assignReply;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ChatRoom> ChatRoomList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Community> commList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // 클래스간의 양방향관계. 관계 주인(외래키 관리 주인)이 아닌 엔티티 클래스명 -> mappedBy = 엔티티 클래스명 // getNoticeList 할때 조인 (조회할때 조인 _ 지연로딩)
    @JsonManagedReference
    private List<Notice> noticeList;
  
    //@JsonManagedReference와 @JsonBackReference 사용:
    // Jackson에서 제공하는 @JsonManagedReference와
    // @JsonBackReference 애노테이션을 사용하여 양방향 관계에서
    // 참조 방향을 지정할 수 있습니다.
}

