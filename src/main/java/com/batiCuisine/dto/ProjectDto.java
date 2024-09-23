package main.java.com.batiCuisine.dto;

import main.java.com.batiCuisine.models.enums.ProjectStatus;
import main.java.com.batiCuisine.models.enums.ProjectType;

import java.util.UUID;

public class ProjectDto {
    private UUID id;
    private String name;
    private double profitMargin;
    private double totalCost;
    private double surfaceArea;
    private ProjectType type;
    private ProjectStatus status;
    private UUID clientId;

    public ProjectDto() {}

    public ProjectDto(UUID id, String name, double profitMargin, double totalCost, double surfaceArea, ProjectType type, ProjectStatus status, UUID clientId) {
        this.id = id;
        this.name = name;
        this.profitMargin = profitMargin;
        this.totalCost = totalCost;
        this.surfaceArea = surfaceArea;
        this.type = type;
        this.status = status;
        this.clientId = clientId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
}
