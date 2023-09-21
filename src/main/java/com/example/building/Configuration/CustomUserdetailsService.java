package com.example.building.Configuration;

import com.example.building.Entity.ClientOfBuilding;
import com.example.building.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserdetailsService implements UserDetailsService {

    private UserRepo userRepo;
    public CustomUserdetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (userRepo.existsByEmail(email)){
            return new UserPrincipal(userRepo.findByEmail(email).orElseThrow());// returns user entity
        }
        throw new UsernameNotFoundException("User not found with username " + email);
    }

}
