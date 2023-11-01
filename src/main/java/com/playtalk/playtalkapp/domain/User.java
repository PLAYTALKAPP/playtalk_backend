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
    @Column(name = "pw", nullable = false)//null을 허용하지 않는다.
    private String pw;
    private String nkname;
    private String email;
    private String phone_number;
    @CreationTimestamp
    private LocalDateTime signup_date;
    private String email_check_code;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // 클래스간의 양방향관계. 관계 주인(외래키 관리 주인)이 아닌 엔티티 클래스명 -> mappedBy = 엔티티 클래스명 // getNoticeList 할때 조인 (조회할때 조인 _ 지연로딩)
    private List<Notice> noticeList;

    //만약에 autoIncrement가 있는 컬럼인경우
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int index;

}

// JPA 연관관계(맵핑)
// 객체 - 객체 맵핑
// 1. 단방향 (한쪽만 참조하는 경우)
// 예) 공지글 - 유저 관계
// 유저 -> 공지글 참조 X
// 공지글 -> 유저를 참조하는 경우
// 공지글 객체안에 유저 엔티티가 포함
// 공지글에서는 JoinColumn 명(외래키)으로 유저를 조회할 수 있다.
// 유저에서는 공지글을 조회할 수 없다.
// 즉, 단방향은 한쪽에서만 데이터 조회를 할 수 있다.

// 2. 양방향 (양쪽모두 참조하는 경우, 즉 서로 다른 단방향관계 2개)
// 예) 공지글 - 유저 관계
// 유저 <-> 공지글 서로 참조하는 경우
// 공지글 객체안에 유저 엔티티 포함 / 유저 객체안에 공지글 엔티티 포함
// 공지글에서는 유저를, 유저에서는 공지글을 조회할 수 있다.
// 외래키 하나로 양쪽이 서로 조인가능
// 두 객체의 연관관계 중 하나를 정해 테이블의 외래키를 관리(등록,수정,삭제)해야함(외래키의 주인)
// 주인이 아닌 쪽은 읽기만 할 수 있다.
// 연관관계의 주인이 아닌 쪽은 mappedBy 속성을 사용한다. // 연관관계의 주인은 mappedBy 속성을 사용하지 않는다.

// 쉽게 연관과계 주인 정하는 방법
// 1. 연관관계의 주인은 테이블에 외래키가 있는 곳 (user_id 가 외래키로 있는 곳 == 공지글 Notice 객체)
// 2. 다대일, 일대다 관계에서 항상 다쪽이 외래키를 가진다. @ManyToOne 이 연관관계의 주인이 된다. mappedBy 를 설정할 수 없다. (@ManyToOne 과 mappedBy 는 동시에 성립불가)

// 외래키 관리의 예
// 공지글, 유저의 관계에서 공지글이 연관과계의 주인인 경우 user_id 외래키로
// 공지글을 생성하거나, 기존 공지글 작성자를 수정하거나 공지글을 삭제하는 권한이 있다.
// Notice notice = new Notice();
// notice.setUser(notice.getuser()); // 외래 키 값 설정
// 반면 주인이 아닌 유저 엔티티는 해당 연관관계에서 공지글을 조회할순는 있지만 새로운 공지글을 생성하거나 공지글의 작성자를 수정하거나, 공지글을 삭제할 권한이 없다.