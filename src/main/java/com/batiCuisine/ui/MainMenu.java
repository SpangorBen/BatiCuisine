package main.java.com.batiCuisine.ui;

import main.java.com.batiCuisine.services.interfaces.*;

import java.util.Scanner;

public class MainMenu {

    private final ProjectUI projectUI;
    private final CostCalculateUI costCalculateUI;
    private final Scanner scanner;

    public MainMenu(ProjectUI projectUI, CostCalculateUI costCalculateUI, Scanner scanner) {
        this.projectUI = projectUI;
        this.costCalculateUI = costCalculateUI;
        this.scanner = scanner;

    }

    public void StartMenu(){
        int choice;
        do {
            System.out.println("Welcome to BatiCuisine");
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Create new project");
            System.out.println("2. Display all projects");
            System.out.println("3. Calculate project cost");
            System.out.println("4. Exit");
            System.out.println("Enter your : ");

            choice = scanner.nextInt();
            scanner.nextLine();
        System.out.println("Option selected: " + choice);
            handleUserSelection(choice);
        } while (choice != 4);
    }

    private void handleUserSelection(int option) {
        switch (option) {
            case 1:
                projectUI.createNewProject();
                break;
            case 2:
//                projectUI.displayAllProjects();
                break;
            case 3:
//                costCalculationUI.calculateProjectCost();
                break;
            case 4:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }
}
