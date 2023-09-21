package com.example.building.Service.impl;

import com.example.building.Entity.ClientOfBuilding;
import com.example.building.Service.ClientOfBuildingService;
import com.example.building.Service.EmailService;
import com.example.building.Service.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PasswordResetServiceImpl implements PasswordResetService {
    private final ClientOfBuildingService userService;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Map<String, String>> resetPassword(String email) {
        Optional<ClientOfBuilding> user = userService.getByEmail(email);
        if (user.isEmpty()) {
            return new ResponseEntity<>(
                    Map.of("message", "Пользователь с такой почтой не найден"), HttpStatus.NOT_FOUND);
        }

        String resetToken = UUID.randomUUID().toString();
        LocalDateTime resetTokenExpireTime = LocalDateTime.now().plusMinutes(30);
        user.get().setResetToken(resetToken);
        user.get().setResetTokenExpireTime(resetTokenExpireTime);
        userService.updateClient(user.get().getUser_id(), user.get());

        String resetUrl = "http://localhost:8080/password/newPassword";
        String reset = resetUrl + "?token=" + resetToken;
        String emailText = "Для сброса пароля перейдите по ссылке: " + reset;

        emailService.sendSimpleMessage(email, "Сброс пароля", emailText);

        Map<String, String> response = Map.of("message", "Письмо с восстановлением пароля отправлено на вашу почту");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, String>> saveNewPassword(String resetToken, String newPassword) {
        Optional<ClientOfBuilding> user = userService.getByResetToken(resetToken);
        if (user.isEmpty() || user.get().getResetTokenExpireTime().isBefore(LocalDateTime.now())) {
            return new ResponseEntity<>(Map.of("message",
                    "Срок действия истек, отправьте запрос на восстановление еще раз!"), HttpStatus.FORBIDDEN);
        }

        user.get().setResetToken(null);
        user.get().setResetTokenExpireTime(null);
        user.get().setPassword(passwordEncoder.encode(newPassword));
        userService.updateClient(user.get().getUser_id(), user.get());

        Map<String, String> response = Map.of("message", "Пароль успешно изменен");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}