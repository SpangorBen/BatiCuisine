package main.java.com.batiCuisine.ui;

import main.java.com.batiCuisine.dto.ClientDto;
import main.java.com.batiCuisine.dto.MaterialDto;
import main.java.com.batiCuisine.dto.ProjectDto;
import main.java.com.batiCuisine.dto.WorkforceDto;
import main.java.com.batiCuisine.services.interfaces.*;
import main.java.com.batiCuisine.utils.Cost;
import main.java.com.batiCuisine.utils.InputValidator;

import java.util.Scanner;
import java.util.UUID;
import java.util.function.Predicate;

public class ProjectUI {
    private final ProjectService projectService;
    private final WorkforceService workforceService;
    private final ClientService clientService;
    private final MaterialService materialService;
    private final QuoteService quoteService;
    private final InputValidator inputValidator;
    private final Scanner scanner;

    public ProjectUI(ProjectService projectService, WorkforceService workforceService, ClientService clientService,
                     MaterialService materialService, QuoteService quoteService, Scanner scanner, InputValidator inputValidator) {
        this.projectService = projectService;
        this.workforceService = workforceService;
        this.clientService = clientService;
        this.materialService = materialService;
        this.quoteService = quoteService;
        this.inputValidator = inputValidator;
        this.scanner = scanner;
    }

    public void createNewProject() {
        System.out.println("--- Search for Client ---");
        System.out.println("1. Search existing client");
        System.out.println("2. Add new client");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        //Client
        ClientDto client;
        if ("1".equals(option)) {
            client = searchClient();
        } else {
            client = addNewClient();
        }

        // Creating project
        ProjectDto projectDto = addProject(client.getId());

        // Creating Material
        MaterialDto materialDto = addMaterial(projectDto.getId());

        // Creating Workforce
        WorkforceDto workforceDto = addWorkforce(projectDto.getId());


    }

    private ProjectDto addProject(UUID id) {
        System.out.println("--- Creating New Project ---");

        String projectName = getValidInput("Enter project name: ", inputValidator::handleString, "Invalid name, please try again.");
        double profitMargin = Double.parseDouble(getValidInput("Enter profit margin: ", inputValidator::handleDouble, "Invalid profit margin, please try again."));
        double surfaceArea = Double.parseDouble(getValidInput("Enter surface area: ", inputValidator::handleDouble, "Invalid surface area, please try again."));

        String projectType;
        System.out.println("Enter Project Type (Renovation / Construction): ");
        do {
            projectType = scanner.nextLine();
            if (!projectType.equalsIgnoreCase("Renovation") && !projectType.equalsIgnoreCase("Construction")) {
                System.out.println("Invalid input! Please enter either 'Renovation' or 'Construction'.");
            }
        } while (!projectType.equalsIgnoreCase("Renovation") && !projectType.equalsIgnoreCase("Construction"));

        ProjectDto project = new ProjectDto(projectName, profitMargin, surfaceArea, projectType, id);
        ProjectDto createdProject = projectService.createProject(project);
        if (createdProject != null) {
            System.out.println("Project added successfully.");
        } else {
            System.out.println("Failed to add project.");
        }
        return createdProject;
    }

    private ClientDto addNewClient() {
        System.out.println("--- Adding New Client ---");

        String clientName = getValidInput("Enter client name: ", inputValidator::handleString, "Invalid name, please try again.");
        String address = getValidInput("Enter client address: ", inputValidator::handleString, "Invalid address, please try again.");
        String phoneNumber = getValidInput("Enter client phone number: ", inputValidator::handlePhone, "Invalid phone number, please try again.");

        String isProfessional;
        do {
            System.out.print("Is the client a professional? (yes/no): ");
            isProfessional = scanner.nextLine();
            if (!"yes".equals(isProfessional) && !"no".equals(isProfessional)) {
                System.out.println("Invalid input, please try again.");
            }
        } while (!"yes".equals(isProfessional) && !"no".equals(isProfessional));

        ClientDto client = new ClientDto(clientName, address, phoneNumber, isProfessional.equalsIgnoreCase("yes"));

        ClientDto createdClient = clientService.addClient(client);
        if (createdClient != null) {
            System.out.println("Client added successfully.");
        } else {
            System.out.println("Failed to add client.");
        }
        return createdClient;
    }

    private MaterialDto addMaterial(UUID id) {
        System.out.println("--- Adding Material ---");

        String type = "Material";
        String materialName = getValidInput("Enter material name: ", inputValidator::handleString, "Invalid name, please try again.");
        double materialCost = Double.parseDouble(getValidInput("Enter material cost: ", inputValidator::handleDouble, "Invalid cost, please try again."));
        double materialQuantity = Double.parseDouble(getValidInput("Enter material quantity: ", inputValidator::handleDouble, "Invalid quantity, please try again."));
        double transportCost = Double.parseDouble(getValidInput("Enter transport cost: ", inputValidator::handleDouble, "Invalid transport cost, please try again."));
        double qualityCoefficient = Double.parseDouble(getValidInput("Enter quality coefficient: ", inputValidator::handleDouble, "Invalid quality coefficient, please try again."));
        double vatRate = Double.parseDouble(getValidInput("Enter VAT rate: ", inputValidator::handleDouble, "Invalid VAT rate, please try again."));

        Cost costCalculator = new Cost();
        double totalPrice = costCalculator.materialCost(materialCost, materialQuantity, qualityCoefficient, transportCost);

        return new MaterialDto(materialName, type, vatRate, totalPrice, id, materialCost, materialQuantity, transportCost, qualityCoefficient);
    }

    private WorkforceDto addWorkforce(UUID id) {
        System.out.println("--- Adding Workforce ---");

        String type = "Workforce";
        String workforceName = getValidInput("Enter workforce name: ", inputValidator::handleString, "Invalid name, please try again.");
        double hourlyRate = Double.parseDouble(getValidInput("Enter workforce cost: ", inputValidator::handleDouble, "Invalid cost, please try again."));
        double hoursWorked = Double.parseDouble(getValidInput("Enter workforce quantity: ", inputValidator::handleDouble, "Invalid quantity, please try again."));
        double workerProductivity = Double.parseDouble(getValidInput("Enter transport cost: ", inputValidator::handleDouble, "Invalid transport cost, please try again."));
        double vatRate = Double.parseDouble(getValidInput("Enter VAT rate: ", inputValidator::handleDouble, "Invalid VAT rate, please try again."));

        Cost costCalculator = new Cost();
        double totalPrice = costCalculator.workforceCost(hourlyRate, hoursWorked, workerProductivity);

        return new WorkforceDto(workforceName, type, vatRate, totalPrice, hourlyRate, hoursWorked, workerProductivity, id);

    }

    private String getValidInput(String prompt, Predicate<String> validator, String errorMessage) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (!validator.test(input)) {
                System.out.println(errorMessage);
            }
        } while (!validator.test(input));
        return input;
    }


    private ClientDto searchClient() {
        return null;
    }
}
