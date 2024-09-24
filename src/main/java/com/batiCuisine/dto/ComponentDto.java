package main.java.com.batiCuisine.dto;

import java.util.UUID;

public class ComponentDto {
    private UUID id;
    private String name;
    private String type;
    private double vatRate;
    private double totalPrice;
    private UUID projectId;

    public ComponentDto(){}

    public ComponentDto(UUID id, String name, String type, double vatRate, double totalPrice, UUID projectId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.vatRate = vatRate;
        this.totalPrice = totalPrice;
        this.projectId = projectId;
    }

    public ComponentDto(String name, String type, double vatRate, double totalPrice, UUID projectId) {
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
    public void setId(UUID id) {
        this.id = id;
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
        return "ComponentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", vatRate=" + vatRate + "%" +
                ", totalPrice=" + totalPrice +"$"+
                ", projectId=" + projectId +
                '}';
    }

}
