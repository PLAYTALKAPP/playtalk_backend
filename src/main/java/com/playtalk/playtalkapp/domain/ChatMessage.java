package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmId;

    private String content;

    @CreationTimestamp
    private LocalDateTime postTime;

    @Enumerated(EnumType.STRING)
    private ChatMessageType messageType = ChatMessageType.ENTER;

    @ManyToOne
    @JoinColumn(name = "crId")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User sender;
    // SELECT distinct cr_id FROM CHATMESSAGE WHERE user_id = #user_id;
}
