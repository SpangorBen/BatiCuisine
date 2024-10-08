package main.java.com.batiCuisine.services;

import main.java.com.batiCuisine.config.DatabaseConnection;
import main.java.com.batiCuisine.dto.ClientDto;
import main.java.com.batiCuisine.models.Client;
import main.java.com.batiCuisine.repositories.interfaces.ClientRepository;
import main.java.com.batiCuisine.services.interfaces.ClientService;
import main.java.com.batiCuisine.utils.Mapper;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final Logger logger = Logger.getLogger(ClientServiceImpl.class.getName());

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDto> getAllClients() {
        try {
            List<Client> clients = clientRepository.getAllClients();
            return clients.stream().map(c -> Mapper.mapToDto(c, ClientDto.class))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            logger.severe("Error fetching all clients");
            throw new RuntimeException("Unable to fetch clients", e);
        }
    }

    public Optional<ClientDto> getClientById(String id) {
        try {
            Optional<Client> client = clientRepository.getClientById(id);
            return  client.map(c -> Mapper.mapToDto(c, ClientDto.class));
        } catch (SQLException e) {
            logger.severe("Error fetching client by id");
            throw new RuntimeException("Unable to fetch client by id", e);
        }
    }

    public ClientDto addClient(ClientDto clientDto) {
        try{
            Client client = Mapper.mapToEntity(clientDto, Client.class);
            client = clientRepository.addClient(client);
            return Mapper.mapToDto(client, ClientDto.class);
        } catch (SQLException e) {
            logger.severe("Error adding client" + e.getMessage());
            throw new RuntimeException("Unable to add client", e);
        }
    }

    public void removeClient(String id) {
        try {
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Client ID cannot be null or empty.");
            }
            clientRepository.removeClient(id);
            logger.info("Client with ID " + id + " removed successfully.");
        } catch (SQLException e) {
            logger.severe("Error removing client with ID " + id + ": " + e.getMessage());
            throw new RuntimeException("Unable to remove client with ID " + id, e);
        }
    }
}
