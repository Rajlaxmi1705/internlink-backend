package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean login(String email, String password) {
        User user = repo.findByEmail(email);

        if (user == null) {
            return false;
        }

        return user.getPassword().equals(password);
    }

    public void register(User user) {
        repo.save(user);
    }
}
