package com.berkayd.WordTandem.dto;

import lombok.Data;

@Data
public class WordRequest {
    String topic;
    String level;
    String word;
}
