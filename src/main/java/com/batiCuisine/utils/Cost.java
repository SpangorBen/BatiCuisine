package main.java.com.batiCuisine.utils;

public class Cost {
    public double materialCost(double unitCost, double quantity, double qualityCoefficient, double transportCost) {
        return (unitCost * quantity * qualityCoefficient) + transportCost;
    }

    public double workforceCost(double hourlyRate, double hours , double productivity) {
        return hourlyRate * hours * productivity;
    }

    public double totalCostWithoutVAT(double materialCostWithoutVAT, double workforceCostWithoutVAT) {
        return materialCostWithoutVAT + workforceCostWithoutVAT;
    }

    public double totalCostWithVAT(double price, double VAT) {
        return price *  (1 + VAT/100);
    }

    public double totalCostWithMargin(double price, double margin) {
        return price * (0 + margin/100);
    }

    public double totalCostWithDiscount(int price, int projects, boolean isProfessional) {
        if (isProfessional){
            switch (projects){
                case 3:
                    return price * 0.90;
                case 5:
                    return price * 0.85;
                case 10:
                    return price * 0.80;
                default:
                    return price * 0.75;
            }
        }else {
            switch (projects){
                case 3:
                    return price * 0.98;
                case 5:
                    return price * 0.94;
                case 10:
                    return price * 0.90;
                default:
                    return price * 0.86;
            }
        }

    }
}

