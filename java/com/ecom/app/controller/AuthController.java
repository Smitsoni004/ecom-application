package com.ecom.app.controller;

import com.ecom.app.dto.UserDto;
import com.ecom.app.entity.User;
import com.ecom.app.repository.UserRepository;
// import com.ecom.app.security.JwtService; // 🔁 Commented out
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    // private final JwtService jwtService; // 🔁 Commented out

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto dto) {
        if (userRepository.findByUsername(dto.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        User user = userRepository.findByUsername(dto.getUsername());
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        // 🔁 Skip JWT for now
        // String token = jwtService.generateToken(user);
        // return ResponseEntity.ok(token);

        return ResponseEntity.ok("Login successful (JWT disabled)");
    }
}
