package com.example.building.Controller;

import com.example.building.Configuration.JwtFilter;
import com.example.building.Model.SignInModel;
import com.example.building.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class Registration {
    private final AuthenticationService authenticationService;
    private final JwtFilter jwtFilter;
    @PostMapping("/google")
    public ResponseEntity<String> startGoogleLogin(@RequestBody SignInModel signInModel) throws Exception {
        authenticationService.registerUser(signInModel);
        return ResponseEntity.ok("Google login initiated.");
    }
    @PostMapping("/signin")
    public ResponseEntity<Object> authenticate(@RequestBody @NotNull SignInModel signInModel) throws Exception {
        if (authenticationService.authenticateUser(signInModel)) {
            return  ResponseEntity.ok(jwtFilter.generateToken(signInModel.getEmail()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed.");
    }
    @PostMapping("/signup")
    public ResponseEntity<Object> register(@RequestBody @NotNull SignInModel signInModel) throws Exception {
        authenticationService.registerUser(signInModel);
        return ResponseEntity.ok("You are successfully registered!");
    }
    @GetMapping("/d")
    public String get(){
        return "hello";
    }


}
