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
    private Long cm_id;

    private String content;

    @CreationTimestamp
    private LocalDateTime post_time;

    @Enumerated(EnumType.STRING)
    private ChatMessageType message_type = ChatMessageType.ENTER;

    @ManyToOne
    @JoinColumn(name = "cr_id")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User sender;
        // SELECT distinct cr_id FROM CHATMESSAGE WHERE user_id = #user_id;
}
