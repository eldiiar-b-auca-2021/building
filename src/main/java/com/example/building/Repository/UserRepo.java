package com.example.building.Repository;

import com.example.building.Entity.ClientOfBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<ClientOfBuilding, Integer> {
    boolean existsByEmail(String email);
    Optional<ClientOfBuilding> findByEmail(String email);
    Optional<ClientOfBuilding> findByResetToken(String token);
}
