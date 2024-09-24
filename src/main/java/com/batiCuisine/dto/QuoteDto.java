package main.java.com.batiCuisine.dto;

import java.time.LocalDate;
import java.util.UUID;

public class QuoteDto {
    private UUID id;
    private UUID projectId;
    private double estimatedCost;
    private LocalDate issueDate;
    private LocalDate validityDate;
    private boolean isAccepted;

    public QuoteDto() {}

    public QuoteDto(UUID id, UUID projectId, double estimatedCost, LocalDate issueDate, LocalDate validityDate, boolean isAccepted) {
        this.id = id;
        this.projectId = projectId;
        this.estimatedCost = estimatedCost;
        this.issueDate = issueDate;
        this.validityDate = validityDate;
        this.isAccepted = isAccepted;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(LocalDate validityDate) {
        this.validityDate = validityDate;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
