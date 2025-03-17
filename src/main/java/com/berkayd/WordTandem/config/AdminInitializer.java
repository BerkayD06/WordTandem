package com.berkayd.WordTandem.config;

import com.berkayd.WordTandem.cons.UserRole;
import com.berkayd.WordTandem.entity.User;
import com.berkayd.WordTandem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsername("admin")) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.ADMIN)
                    .createdAt(LocalDateTime.now())
                    .totalScore(0)
                    .gamesPlayed(0)
                    .gamesWon(0)
                    .averageScore(0.0)
                    .build();
            userRepository.save(admin);
        }
    }
}
