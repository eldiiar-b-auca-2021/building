package com.example.building.Service;

import com.example.building.Entity.ClientOfBuilding;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public interface PasswordResetService {
    ResponseEntity<Map<String, String>> resetPassword(String email);

    ResponseEntity<Map<String, String>> saveNewPassword(String resetToken, String newPassword);

}