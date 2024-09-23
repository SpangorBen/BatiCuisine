package main.java.com.batiCuisine.services;

import main.java.com.batiCuisine.dto.WorkforceDto;
import main.java.com.batiCuisine.repositories.interfaces.WorkforceRepository;
import main.java.com.batiCuisine.services.interfaces.WorkforceService;

import java.nio.file.WatchService;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class WorkforceServiceImpl implements WorkforceService {

    private final WorkforceRepository workforceRepository;
    private final Logger logger = Logger.getLogger(WorkforceServiceImpl.class.getName());

    public WorkforceServiceImpl(WorkforceRepository workforceRepository) {
        this.workforceRepository = workforceRepository;
    }

    @Override
    public WorkforceDto addWorkforce(WorkforceDto workforceDto) {
        return null;
    }

    @Override
    public void removeWorkforce(String id) {

    }

    @Override
    public WorkforceDto updateWorkforce(WorkforceDto workforceDto) {
        return null;
    }

    @Override
    public WorkforceDto getWorkforceById(String id) {
        return null;
    }

    @Override
    public List<WorkforceDto> getWorkforcesByProject(String projectId) {
        return Collections.emptyList();
    }
}
