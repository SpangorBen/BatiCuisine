package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.dto.ProjectDto;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public List<ProjectDto> getAllProjects();
    public Optional<ProjectDto> getProjectById(String id);
    public ProjectDto createProject(ProjectDto projectDto);
    public void removeProject(String id);
}
