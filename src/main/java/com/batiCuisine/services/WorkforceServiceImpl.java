package main.java.com.batiCuisine.services;

import main.java.com.batiCuisine.dto.WorkforceDto;
import main.java.com.batiCuisine.models.Workforce;
import main.java.com.batiCuisine.repositories.interfaces.WorkforceRepository;
import main.java.com.batiCuisine.services.interfaces.WorkforceService;
import main.java.com.batiCuisine.utils.Mapper;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class WorkforceServiceImpl implements WorkforceService {

    private final WorkforceRepository workforceRepository;
    private final Logger logger = Logger.getLogger(WorkforceServiceImpl.class.getName());

    public WorkforceServiceImpl(WorkforceRepository workforceRepository) {
        this.workforceRepository = workforceRepository;
    }

    @Override
    public WorkforceDto addWorkforce(WorkforceDto workforceDto) {
        try {
            Workforce workforce = Mapper.mapToEntity(workforceDto, Workforce.class);
            workforce = workforceRepository.addWorkforce(workforce);
            return Mapper.mapToDto(workforce, WorkforceDto.class);
        } catch (SQLException e) {
            logger.severe("Error adding workforce" + e.getMessage());
            throw new RuntimeException("Unable to add workforce", e);
        }
    }

    @Override
    public void removeWorkforce(String id) {
        try {
            if (id == null || id.isEmpty()) {
                logger.warning("Workforce ID is invalid or empty.");
                throw new IllegalArgumentException("Workforce ID is invalid or empty.");
            }
            workforceRepository.removeWorkforce(id);
            logger.info("Workforce with ID " + id + " removed successfully.");
        } catch (SQLException e) {
            logger.severe("Error removing workforce" + e.getMessage());
            throw new RuntimeException("Unable to remove workforce", e);
        }
    }

    @Override
    public WorkforceDto updateWorkforce(WorkforceDto workforceDto) {
        return null;
    }

    @Override
    public Optional<WorkforceDto> getWorkforceById(String id) {
        return null;
    }

    @Override
    public List<WorkforceDto> getWorkforcesByProject(String projectId) {
        return Collections.emptyList();
    }
}
