package com.berkayd.WordTandem.service.impl;

import com.berkayd.WordTandem.cons.UserRole;
import com.berkayd.WordTandem.dto.UserRequest;
import com.berkayd.WordTandem.dto.WordRequest;
import com.berkayd.WordTandem.entity.User;
import com.berkayd.WordTandem.entity.Word;
import com.berkayd.WordTandem.repository.UserRepository;
import com.berkayd.WordTandem.repository.WordRepository;
import com.berkayd.WordTandem.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final WordRepository wordRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    public String createUser(UserRequest userRequest) {
        User newUser = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(UserRole.ADMIN)
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(newUser);
        return "Admin user created successfully";
    }

    @Override
    public String createWord(WordRequest wordRequest) {
        Word word = objectMapper.convertValue(wordRequest, Word.class);
        word.setLetterCount(wordRequest.getWord().length());
        word.setCreatedAt(LocalDateTime.now());

        wordRepository.save(word);
        return "Word created successfully";
    }

    @Override
    public List<String> createWords(List<WordRequest> requests) {
        return requests.stream()
                .map(request -> {
                    Word word = objectMapper.convertValue(request, Word.class);
                    word.setCreatedAt(LocalDateTime.now());
                    word.setLetterCount(request.getWord().length());
                    wordRepository.save(word);
                    return "Word created: " + word.getWord();
                }).collect(Collectors.toList());
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
}