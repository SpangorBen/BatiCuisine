package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.dto.ClientDto;
import main.java.com.batiCuisine.models.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    public List<Client> getAllClients() throws SQLException;
    public Optional<Client> getClientById(String id) throws SQLException;
    public ClientDto addClient(ClientDto clientDto);
    public void removeClient(String id) throws SQLException;
}
