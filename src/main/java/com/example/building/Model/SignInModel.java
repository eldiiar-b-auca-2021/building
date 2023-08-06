package com.example.building.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class SignInModel {
    private String username;
    private String password;
}
