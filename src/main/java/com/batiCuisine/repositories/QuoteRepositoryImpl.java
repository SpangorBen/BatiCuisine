package main.java.com.batiCuisine.repositories;

import main.java.com.batiCuisine.models.Quote;
import main.java.com.batiCuisine.repositories.interfaces.QuoteRepository;

import java.sql.*;
import java.util.Optional;
import java.util.UUID;

public class QuoteRepositoryImpl implements QuoteRepository {

    private final Connection connection;

    public QuoteRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Quote addQuote(Quote quote) throws SQLException {
        String query = "INSERT INTO Quotes (projectId, estimatedCost, issueDate, validityDate) VALUES (?::uuid, ?, ? , ?)";

        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, quote.getProjectId().toString());
            ps.setDouble(2, quote.getEstimatedCost());
            ps.setObject(3, quote.getIssueDate());
            ps.setObject(4, quote.getValidityDate());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert quote, no rows affected.");
            }

            try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                if(generatedKeys.next()){
                    UUID id = (UUID) generatedKeys.getObject(1);

                    return new Quote(id, quote.getProjectId(), quote.getEstimatedCost(), quote.getIssueDate(), quote.getValidityDate(), quote.isAccepted());
                }else{
                    throw new SQLException("Failed to retrieve inserted client ID.");
                }
            }
        }
    }

    @Override
    public Optional<Quote> getQuoteByProject(String projectId) throws SQLException {
        String query = "SELECT DISTINCT * FROM Quotes WHERE projectId = ?::uuid";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, projectId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Quote(
                            (UUID) rs.getObject("id"),
                            (UUID) rs.getObject("projectId"),
                            rs.getDouble("estimatedCost"),
                            rs.getDate("issueDate").toLocalDate(),
                            rs.getDate("validityDate").toLocalDate(),
                            rs.getBoolean("isAccepted")
                    ));
                }
                return Optional.empty();
            }
        }
    }

    @Override
    public void updateStatus(String id, boolean status) throws SQLException {
        String query = "UPDATE Quotes SET isAccepted = ? WHERE id = ?::uuid";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setBoolean(1, status);
            ps.setString(2, id);
            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Failed to update quote status, no rows affected.");
            }
        }
    }

    @Override
    public Optional<Quote> getQuote(String id) throws SQLException {
        String query = "SELECT DISTINCT * FROM Quotes WHERE id = ?::uuid";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Quote quote = new Quote(
                            (UUID) rs.getObject("id"),
                            (UUID) rs.getObject("projectId"),
                            rs.getDouble("estimatedCost"),
                            rs.getDate("issueDate").toLocalDate(),
                            rs.getDate("validityDate").toLocalDate(),
                            rs.getBoolean("isAccepted")
                    );
                    return Optional.of(quote);
                } else {
                    return Optional.empty();
                }
            }
        }
    }
}
