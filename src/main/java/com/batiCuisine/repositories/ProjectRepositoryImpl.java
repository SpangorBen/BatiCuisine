package main.java.com.batiCuisine.repositories;

import main.java.com.batiCuisine.models.Project;
import main.java.com.batiCuisine.models.enums.ProjectStatus;
import main.java.com.batiCuisine.models.enums.ProjectType;
import main.java.com.batiCuisine.repositories.interfaces.ProjectRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public class ProjectRepositoryImpl implements ProjectRepository {
    private final Connection connection;

    public ProjectRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Project> getProjects() throws SQLException {
        String query = "SELECT DISTINCT * FROM Projects";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try(ResultSet rs = ps.executeQuery()){
                List<Project> projects = new ArrayList<>();
                while(rs.next()){
                    projects.add(mapRowToProject(rs));
                }
                return projects;
            }
        }
    }

    private Project mapRowToProject(ResultSet rs) throws SQLException {
        return new Project(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getDouble("profitMargin"),
                rs.getDouble("totalCost"),
                rs.getDouble("surfaceArea"),
                ProjectType.valueOf(rs.getString("type")),
                ProjectStatus.valueOf(rs.getString("status")),
                UUID.fromString(rs.getString("clientId"))
        );
    }

    public Optional<Project> getProjectById(String id) throws SQLException {
        String query = "SELECT * FROM Projects WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Project project = new Project(
                            UUID.fromString(rs.getString("id")),
                            rs.getString("name"),
                            rs.getDouble("profitMargin"),
                            rs.getDouble("totalCost"),
                            rs.getDouble("surfaceArea"),
                            ProjectType.valueOf(rs.getString("type")),
                            ProjectStatus.valueOf(rs.getString("status")),
                            UUID.fromString(rs.getString("clientId")));
                    return Optional.of(project);
                }else{
                    return Optional.empty();
                }
            }
        }
    }

    public Project addProject(Project project) throws SQLException {
        String query = "INSERT INTO Projects (name, profitMargin, totalCost, surfaceArea, type, status, clientId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, project.getName());
            ps.setDouble(2, project.getProfitMargin());
            ps.setDouble(3, project.getTotalCost());
            ps.setDouble(4, project.getSurfaceArea());
            ps.setObject(5, project.getType());
            ps.setObject(5, project.getStatus());
            ps.setString(6, project.getClientId().toString());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert project, no rows affected.");
            }

            try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                if(generatedKeys.next()){
                    UUID id = UUID.fromString(generatedKeys.getString(1));

                    return new Project(id, project.getName(), project.getProfitMargin(), project.getTotalCost(),
                            project.getSurfaceArea(), project.getType(), project.getStatus(), project.getClientId());
                }else {
                    throw new SQLException("Failed to retrieve inserted workforce ID.");
                }
            }
        }
    }

    public void removeProject(String id) throws SQLException {
        String query = "DELETE FROM projects WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
