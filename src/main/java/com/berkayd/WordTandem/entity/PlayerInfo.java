package com.berkayd.WordTandem.entity;

import lombok.Data;

@Data
class PlayerInfo {
    private String userId;
    private int score;
    private int attemptsUsed;
}
