package com.berkayd.WordTandem.entity;

import com.berkayd.WordTandem.cons.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    @Builder.Default
    private UserRole role = UserRole.PLAYER;

    private int totalScore;
    private LocalDateTime createdAt;
    private int gamesPlayed;
    private int gamesWon;
    private double averageScore;
}