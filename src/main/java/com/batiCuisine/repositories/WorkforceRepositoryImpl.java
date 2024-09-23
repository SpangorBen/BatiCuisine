package main.java.com.batiCuisine.repositories;

import main.java.com.batiCuisine.models.Workforce;
import main.java.com.batiCuisine.repositories.interfaces.WorkforceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class WorkforceRepositoryImpl implements WorkforceRepository {

    private final Connection connection;

    public WorkforceRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Workforce addWorkforce(Workforce workforce) throws SQLException {
        String query = "INSERT INTO Workforce (name, type, vatRate, totalPrice, projectId, hourlyRate, hoursWorked, workerProductivity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, workforce.getName());
            ps.setString(2, workforce.getType().toString());
            ps.setDouble(3, workforce.getVatRate());
            ps.setDouble(4, workforce.getTotalPrice());
            ps.setString(5, workforce.getProjectId().toString());
            ps.setDouble(6, workforce.getHourlyRate());
            ps.setDouble(7, workforce.getHoursWorked());
            ps.setDouble(8, workforce.getWorkerProductivity());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert workforce, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    UUID id = UUID.fromString(generatedKeys.getString(1));
                    return new Workforce(id, workforce.getName(), workforce.getType(), workforce.getVatRate(), workforce.getTotalPrice(),
                            workforce.getProjectId(), workforce.getHourlyRate(), workforce.getHoursWorked(), workforce.getWorkerProductivity());
                } else {
                    throw new SQLException("Failed to retrieve inserted workforce ID.");
                }
            }
        }
    }

    @Override
    public void removeWorkforce(String id) throws SQLException {
        String query = "DELETE FROM Workforce WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Workforce updateWorkforce(Workforce workforce) throws SQLException {
        return null;
    }

    @Override
    public Optional<Workforce> getWorkforceById(String id) throws SQLException {
        String query = "SELECT * FROM Workforce WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Workforce workforce = new Workforce(
                            (UUID) rs.getObject("id"),
                            rs.getString("name"),
                            UUID.fromString(rs.getString("type")),
                            rs.getDouble("vatRate"),
                            rs.getDouble("totalPrice"),
                            (UUID) rs.getObject("projectId"),
                            rs.getDouble("hourlyRate"),
                            rs.getDouble("hoursWorked"),
                            rs.getDouble("workerProductivity")
                    );
                    return Optional.of(workforce);
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    @Override
    public List<Workforce> getWorkforcesByProject(String projectId) throws SQLException {
        String query = "SELECT * FROM Workforce WHERE projectId = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, projectId);

            try (ResultSet rs = ps.executeQuery()) {
                List<Workforce> workforces = new ArrayList<>();
                while  (rs.next()) {
                    workforces.add(new Workforce(
                            (UUID) rs.getObject("id"),
                            rs.getString("name"),
                            UUID.fromString(rs.getString("type")),
                            rs.getDouble("vatRate"),
                            rs.getDouble("totalPrice"),
                            (UUID) rs.getObject("projectId"),
                            rs.getDouble("hourlyRate"),
                            rs.getDouble("hoursWorked"),
                            rs.getDouble("workerProductivity")
                    ));
                }
                return workforces;
            }
        }
    }
}
