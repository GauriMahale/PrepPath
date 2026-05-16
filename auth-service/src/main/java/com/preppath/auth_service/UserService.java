package main.java.com.preppath.auth_service;

import java.util.List;
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

    
    
}
