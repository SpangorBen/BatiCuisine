package main.java.com.batiCuisine.models;

import main.java.com.batiCuisine.models.enums.ProjectType;

import java.util.UUID;

public class Component {
    private UUID id;
    private String name;
    private String type;
    private double vatRate;
    private double totalPrice;
    private UUID projectId;

    public Component(){}

    public Component(UUID id, String name, String type, double vatRate, double totalPrice, UUID projectId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.vatRate = vatRate;
        this.totalPrice = totalPrice;
        this.projectId = projectId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", vatRate=" + vatRate +
                ", totalPrice=" + totalPrice +
                ", projectId=" + projectId +
                '}';
    }
}
