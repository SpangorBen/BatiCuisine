package main.java.com.batiCuisine.services;

import main.java.com.batiCuisine.dto.ProjectDto;
import main.java.com.batiCuisine.models.Project;
import main.java.com.batiCuisine.repositories.interfaces.ProjectRepository;
import main.java.com.batiCuisine.services.interfaces.ProjectService;
import main.java.com.batiCuisine.utils.Mapper;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final Logger logger = Logger.getLogger(ProjectServiceImpl.class.getName());

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<ProjectDto> getAllProjects() {
        try {
             List<Project> projects = projectRepository.getProjects();
            return projects.stream()
                    .map(c -> Mapper.mapToDto(c, ProjectDto.class))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            logger.severe("Error fetching all projects");
            throw new RuntimeException("Unable to fetch projects", e);
        }
    }

    @Override
    public Optional<ProjectDto> getProjectById(String id) {
        try {
            Optional<Project> project = projectRepository.getProjectById(id);
            return project.map(c -> Mapper.mapToDto(c, ProjectDto.class));
        } catch (SQLException e) {
            logger.severe("Error fetching project by id");
            throw new RuntimeException("Unable to fetch project by id", e);
        }
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        try {
            Project project = Mapper.mapToEntity(projectDto, Project.class);
            projectRepository.addProject(project);
            return Mapper.mapToDto(project, ProjectDto.class);
        } catch (SQLException e) {
            logger.severe("Error creating project" + e.getMessage());
            throw new RuntimeException("Unable to create project", e);
        }
    }

    @Override
    public void removeProject(String id) {
        try {
            if (id == null || id.isEmpty()){
                logger.severe("ID field must be filled in");
                throw new IllegalArgumentException("Client ID cannot be null or empty.");
            }
            projectRepository.removeProject(id);
            logger.info("Project removed successfully");
        } catch (SQLException e) {
            logger.severe("Error removing project with ID " + id + ": " + e.getMessage());
            throw new RuntimeException("Unable to remove project", e);
        }
    }
}
