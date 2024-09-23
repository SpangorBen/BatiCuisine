package main.java.com.batiCuisine.dto;

import java.util.UUID;

public class ClientDto {
    private UUID id;
    private String name;
    private String address;
    private String phoneNumber;
    private boolean isProfessional;

    public ClientDto() {
    }

    public ClientDto(String name, String address, String phoneNumber, boolean isProfessional) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isProfessional = isProfessional;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isProfessional() {
        return isProfessional;
    }

    public void setProfessional(boolean professional) {
        isProfessional = professional;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isProfessional=" + isProfessional +
                '}';
    }
}