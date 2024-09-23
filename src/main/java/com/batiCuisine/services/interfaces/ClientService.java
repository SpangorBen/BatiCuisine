package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.models.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface ClientService {
    public ArrayList<Client> getAllClients() throws SQLException;
    public Optional<Client> getClientById(String id) throws SQLException;
    public Client addClient(Client client) throws SQLException;
    public void removeClient(String id) throws SQLException;
}
