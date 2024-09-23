package main.java.com.batiCuisine.services;

import main.java.com.batiCuisine.dto.MaterialDto;
import main.java.com.batiCuisine.models.Material;
import main.java.com.batiCuisine.repositories.interfaces.MaterialRepository;
import main.java.com.batiCuisine.services.interfaces.MaterialService;
import main.java.com.batiCuisine.utils.Mapper;


import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final Logger logger = Logger.getLogger(MaterialServiceImpl.class.getName());

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<MaterialDto> getMaterialsByProject(String projectId) {
        if (projectId == null || projectId.isEmpty()) {
            logger.severe("Project ID must be provided and cannot be empty");
            throw new IllegalArgumentException("Project ID must be provided");
        }

        try {
            List<Material> materials = materialRepository.getMaterialsByProject(projectId);
            return materials.stream()
                    .map(material -> Mapper.mapToDto(material, MaterialDto.class))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            logger.severe("Error fetching materials for project ID: " + projectId + ". Error: " + e.getMessage());
            throw new RuntimeException("Unable to fetch materials for project", e);
        }
    }

    @Override
    public Optional<MaterialDto> getMaterialById(String id) {
        try {
            Optional<Material> material = materialRepository.getMaterialById(id);
            return material.map(m -> Mapper.mapToDto(m, MaterialDto.class));
        } catch (Exception e) {
            logger.severe("Error fetching material by id");
            throw new RuntimeException("Unable to fetch material by id", e);
        }
    }

    @Override
    public MaterialDto addMaterial(MaterialDto materialDto) {
        try {
            Material material = Mapper.mapToEntity(materialDto, Material.class);
            material = materialRepository.addMaterial(material);
            return Mapper.mapToDto(material, MaterialDto.class);
        } catch (Exception e) {
            logger.severe("Error adding material" + e.getMessage());
            throw new RuntimeException("Unable to add material", e);
        }
    }

    @Override
    public void removeMaterial(String id) {
        try {
            if (id == null || id.isEmpty()){
                throw new IllegalArgumentException("ID field must be filled in");
            }
            materialRepository.removeMaterial(id);
            logger.info("Material removed successfully");
        } catch (Exception e) {
            logger.severe("Error removing material ID: " + id + " " + e.getMessage());
            throw new RuntimeException("Unable to remove material with ID" + id, e);
        }
    }

    @Override
    public MaterialDto updateMaterial(MaterialDto materialDto) {
        return null;
    }


}
