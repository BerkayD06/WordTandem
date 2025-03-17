package com.berkayd.WordTandem.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "words")
@Data
public class Word {
    @Id
    private String id;

    @Indexed
    private String topic;

    @Indexed
    private String level;

    @Indexed
    private int letterCount;

    @TextIndexed
    private String word;

    private LocalDateTime createdAt;
    private String createdBy;
}