package main.java.com.batiCuisine.dto;

import java.util.UUID;

public class WorkforceDto extends ComponentDto{
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;

    public WorkforceDto(){}

    public WorkforceDto(String name, String type, double vatRate, double totalPrice, double hourlyRate, double hoursWorked, double workerProductivity, UUID projectId) {
        super(name, type, vatRate, totalPrice, projectId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }

    public WorkforceDto(UUID id, String name, String type, double vatRate, double totalPrice, double hourlyRate, double hoursWorked, double workerProductivity, UUID projectId) {
        super(id, name, type, vatRate, totalPrice, projectId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }


}
