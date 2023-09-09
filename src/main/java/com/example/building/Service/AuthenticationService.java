package com.example.building.Service;

import com.example.building.Entity.ClientOfBuilding;
import com.example.building.Enums.RoleName;
import com.example.building.Model.SignInModel;
import com.example.building.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;

    public void registerUser(SignInModel signInModel) throws Exception {
        ClientOfBuilding clientOfBuilding = new ClientOfBuilding();
        if (!userRepo.existsByEmail(signInModel.getEmail())) {
            clientOfBuilding.setEmail(signInModel.getEmail());
            clientOfBuilding.setPassword(encoder.encode(signInModel.getPassword()));
            clientOfBuilding.setName(RoleName.ROLE_ADMIN);
            userRepo.save(clientOfBuilding);
        }else {
            throw new Exception("Email already exists!!!");
        }
    }

    public boolean authenticateUser(SignInModel signInModel) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInModel.getEmail(), signInModel.getPassword()));
        if (authentication.isAuthenticated()) {
            return true;
        }
        throw new Exception("User was not registered before!!!");
    }
}
