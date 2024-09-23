package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.dto.ClientDto;
import main.java.com.batiCuisine.models.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    public List<ClientDto> getAllClients();
    public Optional<ClientDto> getClientById(String id);
    public ClientDto addClient(ClientDto clientDto);
    public void removeClient(String id);
}
