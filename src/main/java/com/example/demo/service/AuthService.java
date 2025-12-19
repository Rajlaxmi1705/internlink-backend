package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    // ✅ LOGIN (PRODUCTION SAFE)
    public boolean login(String email, String password) {

        return repo.findByEmail(email)
                .map(user -> encoder.matches(password, user.getPassword()))
                .orElse(false);
    }

    // ✅ REGISTER (HASH PASSWORD)
    public void register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }
}
