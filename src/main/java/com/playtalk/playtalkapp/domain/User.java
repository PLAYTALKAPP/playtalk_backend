package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.expression.spel.ast.Assign;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="users")
public class User {
    @Id
    @Column
    private String user_id;
    @Column(name="pw",nullable=false)//null을 허용하지 않는다.
    private String pw;
    private String nkname;
    private String email;
    private String phone_number;
    @CreationTimestamp
    private LocalDateTime signup_date;
    //Status
    private GradeType grade;
    private String email_check_code;


    @OneToMany(mappedBy = "user_id")
    private List<ChatRooms> chatRooms;

    @OneToMany(mappedBy = "user_id")
    private List<Assign> assigns;




//만약에 autoIncrement가 있는 컬럼인경우
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int index;

}
