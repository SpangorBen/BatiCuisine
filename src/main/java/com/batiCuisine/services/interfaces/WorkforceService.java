package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.dto.WorkforceDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface WorkforceService {
    public WorkforceDto addWorkforce(WorkforceDto workforceDto);
    public void removeWorkforce(String id);
    public WorkforceDto updateWorkforce(WorkforceDto workforceDto);
    public WorkforceDto getWorkforceById(String id);
    public List<WorkforceDto> getWorkforcesByProject(String projectId);
}
