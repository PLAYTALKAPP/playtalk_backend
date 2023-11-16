package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comm_imgs")
public class CommImgs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long img_id;
    @Column(nullable = false)
    private String img_path;
    private boolean img_main;

    @ManyToOne
    @JoinColumn(name = "comm_id")
    private Community community;
}
