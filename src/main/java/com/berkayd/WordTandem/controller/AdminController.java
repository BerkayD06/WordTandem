package com.berkayd.WordTandem.controller;

import com.berkayd.WordTandem.dto.UserRequest;
import com.berkayd.WordTandem.dto.WordRequest;
import com.berkayd.WordTandem.entity.Word;
import com.berkayd.WordTandem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create-admin")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(adminService.createUser(userRequest));
    }

    @PostMapping("/create-word")
    public ResponseEntity<String> createWord(@RequestBody WordRequest request) {
        return ResponseEntity.ok(adminService.createWord(request));
    }

    @PostMapping("/create-words")
    public ResponseEntity<List<String>> createWords(@RequestBody List<WordRequest> requests) {
        return ResponseEntity.ok(adminService.createWords(requests));
    }

    @GetMapping("/words")
    public ResponseEntity<List<Word>> getAllWords() {
        return ResponseEntity.ok(adminService.getAllWords());
    }
}