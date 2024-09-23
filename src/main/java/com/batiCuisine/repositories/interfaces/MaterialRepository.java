package main.java.com.batiCuisine.repositories.interfaces;

import main.java.com.batiCuisine.models.Material;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface MaterialRepository {
    public Material addMaterial(Material material) throws SQLException;
    public void removeMaterial(String id) throws SQLException;
    public Material updateMaterial(Material material) throws SQLException;
    public Optional<Material> getMaterialById(String id) throws SQLException;
    public ArrayList<Material> getMaterialsByProject(String projectId) throws SQLException;
}
