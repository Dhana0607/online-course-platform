package com.dhana.OnlineLearning.controller;

import com.dhana.OnlineLearning.dto.AuthRequest;
import com.dhana.OnlineLearning.dto.AuthResponse;
import com.dhana.OnlineLearning.model.User;
import com.dhana.OnlineLearning.service.UserService;
import com.dhana.OnlineLearning.util.Jwtutil;
import com.dhana.OnlineLearning.config.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Jwtutil jwtUtil;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User Registered Successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(new AuthResponse("Invalid credentials"));
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<String> getProfile(Authentication authentication) {
        return ResponseEntity.ok("Hello " + authentication.getName() + "! Your token is working.");
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}

