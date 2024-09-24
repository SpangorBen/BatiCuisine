package main.java.com.batiCuisine.ui;

import main.java.com.batiCuisine.services.interfaces.*;

public class MainMenu {

    private final ClientService clientService;
    private final ProjectService projectService;
    private final MaterialService materialService;
    private final WorkforceService workforceService;
    private final QuoteService quoteService;

    public MainMenu(ClientService clientService, ProjectService projectService, MaterialService materialService,
                    WorkforceService workforceService, QuoteService quoteService){
        this.clientService = clientService;
        this.projectService = projectService;
        this.materialService = materialService;
        this.workforceService = workforceService;
        this.quoteService = quoteService;
    }

    public void StartMenu(){
        System.out.println("Welcome to BatiCuisine");
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Create new project");
        System.out.println("2. Display all projects");
        System.out.println("3. Calculate project cost");
        System.out.println("4. Exit");



    }
}
