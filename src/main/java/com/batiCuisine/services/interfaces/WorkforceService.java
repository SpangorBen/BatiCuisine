package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.dto.WorkforceDto;

import java.util.List;
import java.util.Optional;

public interface WorkforceService {
    public WorkforceDto addWorkforce(WorkforceDto workforceDto);
    public void removeWorkforce(String id);
    public WorkforceDto updateWorkforce(WorkforceDto workforceDto);
    public Optional<WorkforceDto> getWorkforceById(String id);
    public List<WorkforceDto> getWorkforcesByProject(String projectId);
}
