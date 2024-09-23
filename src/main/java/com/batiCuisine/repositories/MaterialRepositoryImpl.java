package main.java.com.batiCuisine.repositories;

import main.java.com.batiCuisine.models.Material;
import main.java.com.batiCuisine.repositories.interfaces.MaterialRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class MaterialRepositoryImpl implements MaterialRepository {

    private final Connection connection;

    public MaterialRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Material addMaterial(Material material) throws SQLException {
        String query = "INSERT INTO Materials (name, type, vatRate, totalPrice, projectId, unitCost, quantity, transportCost, qualityCoefficient) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, material.getName());
            ps.setString(2, material.getType().toString());
            ps.setDouble(3, material.getVatRate());
            ps.setDouble(4, material.getTotalPrice());
            ps.setString(5, material.getProjectId().toString());
            ps.setDouble(6, material.getUnitCost());
            ps.setDouble(7, material.getQuantity());
            ps.setDouble(8, material.getTransportCost());
            ps.setDouble(9, material.getQualityCoefficient());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert material, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    UUID id = (UUID) generatedKeys.getObject(1);

                    return new Material(id, material.getName(), material.getType(), material.getVatRate(), material.getTotalPrice(), material.getProjectId(), material.getUnitCost(), material.getQuantity(), material.getTransportCost(), material.getQualityCoefficient());
                }else {
                    return null;
                }
            }
        }
    }

    @Override
    public void removeMaterial(String id) throws SQLException {

    }

    @Override
    public Material updateMaterial(Material material) throws SQLException {
        return null;
    }

    @Override
    public Optional<Material> getMaterialById(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public ArrayList<Material> getMaterialsByProject(String projectId) throws SQLException {
        return null;
    }
}
