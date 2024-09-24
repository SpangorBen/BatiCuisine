package main.java.com.batiCuisine;


import main.java.com.batiCuisine.config.DatabaseConnection;
import main.java.com.batiCuisine.repositories.*;
import main.java.com.batiCuisine.services.*;
import main.java.com.batiCuisine.ui.CostCalculateUI;
import main.java.com.batiCuisine.ui.MainMenu;
import main.java.com.batiCuisine.ui.ProjectUI;
import main.java.com.batiCuisine.utils.InputValidator;

import java.sql.Connection;
import java.util.Scanner;

public class BatiCuisine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DatabaseConnection.getConnection();

        InputValidator inputValidator = new InputValidator();
        ClientRepositoryImpl clientRepository = new ClientRepositoryImpl(connection);
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl(connection);
        MaterialRepositoryImpl materialRepository = new MaterialRepositoryImpl(connection);
        WorkforceRepositoryImpl workforceRepository = new WorkforceRepositoryImpl(connection);

        QuoteRepositoryImpl quoteRepository = new QuoteRepositoryImpl(connection);
        ClientServiceImpl clientService = new ClientServiceImpl(clientRepository);
        ProjectServiceImpl projectService = new ProjectServiceImpl(projectRepository);
        MaterialServiceImpl materialService = new MaterialServiceImpl(materialRepository);
        WorkforceServiceImpl workforceService = new WorkforceServiceImpl(workforceRepository);

        QuoteServiceImpl quoteService = new QuoteServiceImpl(quoteRepository);
        CostCalculateUI costCalculateUI = new CostCalculateUI();
        ProjectUI projectUI = new ProjectUI(projectService, workforceService, clientService, materialService, quoteService, scanner, inputValidator);

        MainMenu mainMenu = new MainMenu(projectUI, costCalculateUI, scanner);
        mainMenu.StartMenu();

    }
}