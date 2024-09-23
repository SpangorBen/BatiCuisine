package main.java.com.batiCuisine.services;

import main.java.com.batiCuisine.models.Client;
import main.java.com.batiCuisine.services.interfaces.ClientService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    public ArrayList<Client> getAllClients() throws SQLException {
        return null;
    }

    public Optional<Client> getClientById(String id) throws SQLException {
        return null;
    }

    public Client addClient(Client client) throws SQLException {
        return null;
    }

    public void removeClient(String id) throws SQLException {
    }
}
