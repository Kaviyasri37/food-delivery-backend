package com.example.foodapp.Controller;

import com.example.foodapp.Entity.User;
import com.example.foodapp.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "Email already registered";
        }

        userRepository.save(user);

        return "Registration successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userRepository.findByEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        );

        if (existingUser != null) {
            return "Login successful";
        }

        return "Invalid email or password";
    }
}