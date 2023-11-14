package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="chat_rooms")
public class ChatRooms {
    @Id
    @Column(name="cr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cr_id;
    @Column(name="user_id",nullable=false)
    private String user_id;
    @Column(name="room_name",nullable=false)
    private String room_name;
    @Column(name="description",nullable=false)
    private String description ;
    @Column(name="post_time",nullable=false)
    private LocalDateTime post_time;
    @Column(name="update_time",nullable=false)
    private LocalDateTime update_time;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "chat_messages")
    private List<ChatMessages> chatMessages;


}


