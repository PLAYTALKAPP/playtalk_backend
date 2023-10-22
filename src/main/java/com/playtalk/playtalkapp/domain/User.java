package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name="users")
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
    //Status

    private String email_check_code;

    //만약에 autoIncrement가 있는 컬럼인경우
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int index;

}
