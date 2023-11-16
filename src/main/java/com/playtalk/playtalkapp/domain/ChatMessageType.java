package com.playtalk.playtalkapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChatMessageType {
    CHAT,
    ENTER,
    EXIT,
}
