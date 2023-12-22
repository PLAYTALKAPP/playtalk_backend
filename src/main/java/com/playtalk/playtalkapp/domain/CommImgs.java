package com.playtalk.playtalkapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommImgs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgId;

    @Column(nullable = false)
    private String imgPath;

    private boolean imgMain;

    @ManyToOne
    @JoinColumn(name = "commId")
    private Community community;
}
