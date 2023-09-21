package com.example.building.Service.impl;

import com.example.building.Entity.ClientOfBuilding;
import com.example.building.Repository.UserRepo;
import com.example.building.Service.ClientOfBuildingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientOfBuildingServiceImpl implements ClientOfBuildingService {
    private final UserRepo clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientOfBuildingServiceImpl(UserRepo clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<ClientOfBuilding> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientOfBuilding getClientById(Integer id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User wis id " + id + " not found!")
        );
    }

    @Override
    public ClientOfBuilding createClient(ClientOfBuilding client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    @Override
    public ClientOfBuilding updateClient(Integer id, ClientOfBuilding updatedClient) {
        ClientOfBuilding existingClient = getClientById(id);
        if (existingClient != null) {
            existingClient.setFirstname(updatedClient.getFirstname());
            existingClient.setLastname(updatedClient.getLastname());
            existingClient.setPassword(updatedClient.getPassword());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setBirthDate(updatedClient.getBirthDate());
            existingClient.setName(updatedClient.getName());
            return clientRepository.save(existingClient);
        }
        return null;
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<ClientOfBuilding> getByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Optional<ClientOfBuilding> getByResetToken(String token) {
        return clientRepository.findByResetToken(token);
    }

}
