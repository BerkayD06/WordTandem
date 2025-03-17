package com.berkayd.WordTandem.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WordGuess {
    private String playerId;
    private String guessedWord;
    private int score;
    private LocalDateTime timestamp;
}
