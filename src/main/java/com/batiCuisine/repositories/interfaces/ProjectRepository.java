package main.java.com.batiCuisine.repositories.interfaces;

import main.java.com.batiCuisine.models.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    public List<Project> getProjects() throws SQLException;
    public Optional<Project> getProjectById(String id) throws SQLException;
    public Project addProject(Project project) throws SQLException;
    public void removeProject(String id) throws SQLException;
}
