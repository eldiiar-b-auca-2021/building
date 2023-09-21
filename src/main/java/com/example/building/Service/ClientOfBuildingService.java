package com.example.building.Service;

import com.example.building.Entity.ClientOfBuilding;

import java.util.List;
import java.util.Optional;

public interface ClientOfBuildingService {
    List<ClientOfBuilding> getAllClients();

    ClientOfBuilding getClientById(Integer id);

    ClientOfBuilding createClient(ClientOfBuilding client);

    ClientOfBuilding updateClient(Integer id, ClientOfBuilding client);

    void deleteClient(Integer id);

    Optional<ClientOfBuilding> getByEmail(String email);

    Optional<ClientOfBuilding> getByResetToken(String token);

}
