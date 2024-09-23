package main.java.com.batiCuisine.repositories;

import main.java.com.batiCuisine.models.Client;
import main.java.com.batiCuisine.repositories.interfaces.ClientRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientRepositoryImpl implements ClientRepository {

    private final Connection connection;
    private static final Logger logger = Logger.getLogger(ClientRepository.class.getName());

    public ClientRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Client> getAllClients() throws SQLException {
        String query = "SELECT * FROM Clients";

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            List<Client> clients = new ArrayList<>();
            while (rs.next()) {
                clients.add(mapRowToClient(rs));
            }
            return clients;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching all clients", e);
            throw e;
        }
    }

    private Client mapRowToClient(ResultSet rs) throws SQLException {
        return new Client(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("phoneNumber"),
                rs.getBoolean("isProfessional")
        );
    }

    @Override
    public Optional<Client> getClientById(String id) throws SQLException {
        String query = "SELECT * FROM Clients WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Client client = new Client(
                            UUID.fromString(rs.getString("id")),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("phoneNumber"),
                            rs.getBoolean("isProfessional")
                    );
                    return Optional.of(client);
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    @Override
    public Client addClient(Client client) throws SQLException {
        String query = "INSERT INTO clients (name, phoneNumber, address, isProfessional) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getPhoneNumber());
            ps.setString(3, client.getAddress());
            ps.setBoolean(4, client.isProfessional());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Failed to insert client, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    UUID clientId = (UUID) generatedKeys.getObject(1);

                    return new Client(clientId, client.getName(), client.getAddress(), client.getPhoneNumber(), client.isProfessional());
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void removeClient(String id) throws SQLException {
        String query = "DELETE FROM Clients WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);
            ps.executeUpdate();
        }

    }
}
