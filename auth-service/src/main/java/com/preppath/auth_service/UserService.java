package com.preppath.auth_service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String saveUser(User u)
    {
        return userRepo.save(u).getName() + " saved successfully";
    }

    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);

        if (user != null && Objects.equals(user.getPassword(), password)) {
            return user;
        }

        return null;
    }
}
