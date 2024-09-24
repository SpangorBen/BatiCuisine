package main.java.com.batiCuisine.dto;

import java.util.UUID;

public class MaterialDto extends ComponentDto{
    private double unitCost;
    private double quantity;
    private double transportCost;
    private double qualityCoefficient;

    public MaterialDto(){}

    public MaterialDto(UUID id, String name, String type, double vatRate, double totalPrice, UUID projectId, double unitCost, double quantity, double transportCost, double qualityCoefficient) {
        super(id, name, type, vatRate, totalPrice, projectId);
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.transportCost = transportCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    public MaterialDto(String name, String type, double vatRate, double totalPrice, UUID projectId, double unitCost, double quantity, double transportCost, double qualityCoefficient) {
        super(name, type, vatRate, totalPrice, projectId);
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.transportCost = transportCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    public double getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTransportCost() {
        return transportCost;
    }
    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }
    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", unitCost=" + unitCost + "$"+
                ", quantity=" + quantity +
                ", transportCost=" + transportCost + "$"+
                ", qualityCoefficient=" + qualityCoefficient +
                '}';
    }

}
