package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="chat_messages")
public class ChatMessages {
    @Id
    @Column(name="cm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cm_id;
    @Column(name="cr_id",nullable=false)
    private int cr_id;
    @Column(name="user_id",nullable=false)
    private String user_id;
    @Column(name="nkname",nullable=false)
    private String nkname;
    @Column(name="content",nullable=false)
    private String content ;

   @Enumerated
    @Column(name="status",nullable=false)
    private StatusType status;
    @Column(name="post_time",nullable=false)
    private LocalDateTime post_time;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cr_id")
    private ChatRooms chatRoom;
}

