package com.berkayd.WordTandem.entity;

import com.berkayd.WordTandem.cons.GameStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "game_sessions")
@Data
public class GameSession {
    @Id
    private String sessionId;

    @Indexed
    private GameStatus gameStatus;

    private String selectedLevel;
    private String selectedTopic;
    private int selectedLetterCount;

    private List<PlayerInfo> players = new ArrayList<>();

    private String currentWordId;
    private List<WordGuess> guesses = new ArrayList<>();

    private int currentPlayerIndex;
    private int maxAttempts;
    private int remainingAttempts;

    private LocalDateTime createdAt;
    private LocalDateTime endedAt;
}