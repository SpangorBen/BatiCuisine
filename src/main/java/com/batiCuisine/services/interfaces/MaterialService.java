package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.dto.MaterialDto;
import main.java.com.batiCuisine.models.Material;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MaterialService {
    public MaterialDto addMaterial(MaterialDto materialDto);
    public void removeMaterial(String id);
    public MaterialDto updateMaterial(MaterialDto materialDto);
    public Optional<MaterialDto> getMaterialById(String id);
    public List<MaterialDto> getMaterialsByProject(String projectId);
}
