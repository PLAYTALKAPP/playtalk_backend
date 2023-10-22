package com.playtalk.playtalkapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="community")
public class Community {
    @Id
    @Column
    private int comm_id;

    private String user_id;
    private String title;
    private String content;
    private int view_count;
    private LocalDateTime post_time;

}
