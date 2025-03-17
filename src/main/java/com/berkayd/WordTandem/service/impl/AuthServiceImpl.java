package com.berkayd.WordTandem.service.impl;

import com.berkayd.WordTandem.cons.UserRole;
import com.berkayd.WordTandem.entity.User;
import com.berkayd.WordTandem.repository.UserRepository;
import com.berkayd.WordTandem.service.AuthService;
import com.berkayd.WordTandem.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsServiceImpl userDetailsService;

    public Map<String, String> registerUser(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode("defaultPassword"))
                .role(UserRole.PLAYER)
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
        return generateTokenResponse(user);
    }

    public Map<String, String> loginUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return generateTokenResponse(user);
    }

    private Map<String, String> generateTokenResponse(User user) {
        String token = jwtUtil.generateToken(
                userDetailsService.loadUserByUsername(user.getUsername())
        );
        return Collections.singletonMap("token", token);
    }
}