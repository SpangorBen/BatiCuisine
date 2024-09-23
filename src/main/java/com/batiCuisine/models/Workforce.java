package main.java.com.batiCuisine.models;

import java.util.UUID;

public class Workforce extends Component{
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;

    public Workforce(){}

    public Workforce(UUID id, String name, UUID type, double vatRate, double totalPrice, UUID projectId, double hourlyRate, double hoursWorked, double workerProductivity) {
        super(id, name, type, vatRate, totalPrice, projectId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getWorkerProductivity() {
        return workerProductivity;
    }

    public void setWorkerProductivity(double workerProductivity) {
        this.workerProductivity = workerProductivity;
    }
}
