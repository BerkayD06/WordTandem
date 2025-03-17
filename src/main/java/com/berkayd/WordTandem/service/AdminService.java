package com.berkayd.WordTandem.service;

import com.berkayd.WordTandem.dto.UserRequest;
import com.berkayd.WordTandem.dto.WordRequest;
import com.berkayd.WordTandem.entity.Word;

import java.util.List;

public interface AdminService {
    String createUser(UserRequest userRequest);

    String createWord(WordRequest request);

    List<String> createWords(List<WordRequest> requests);

    List<Word> getAllWords();
}
