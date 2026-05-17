package com.preppath.auth_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserContoller {    

    @Autowired
    private UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email,
                                          @RequestParam String password) {

        User loggedInUser = userService.login(email, password);

        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }

        return ResponseEntity.status(401).body(null);
    }

}
