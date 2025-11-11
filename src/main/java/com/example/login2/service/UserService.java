package com.example.login2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login2.entity.AppUser;
import com.example.login2.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser registerUser(String username, String rawPassword) {
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(rawPassword); // 今は暗号化なし
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }
}
