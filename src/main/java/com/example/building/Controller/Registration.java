package com.example.building.Controller;

import com.example.building.Model.SignInModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestController
//@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class Registration {
    private final AuthenticationManager authenticationManager;
    @PostMapping("/signin")
    public ResponseEntity<Object> authenticate(@RequestBody @NotNull SignInModel signInModel) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInModel.getUsername(), signInModel.getPassword()));
            if (authentication.isAuthenticated()) {
                return ResponseEntity.ok("User authenticated successfully!");
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed.");
    }
    @GetMapping("/d")
    public String get(){
        return "helloo";
    }


}
