package main.java.com.batiCuisine.repositories.interfaces;

import main.java.com.batiCuisine.models.Workforce;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface WorkforceRepository {
    public Workforce addWorkforce(Workforce workforce) throws SQLException;
    public void removeWorkforce(String id) throws SQLException;
    public Workforce updateWorkforce(Workforce workforce) throws SQLException;
    public Optional<Workforce> getWorkforceById(String id) throws SQLException;
    public List<Workforce> getWorkforcesByProject(String projectId) throws SQLException;
}
