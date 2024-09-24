package main.java.com.batiCuisine.repositories.interfaces;

import main.java.com.batiCuisine.models.Quote;

import java.sql.SQLException;
import java.util.Optional;

public interface QuoteRepository {
    public Quote addQuote(Quote quote) throws SQLException;
    public Optional<Quote> getQuoteByProject(String projectId) throws SQLException;
    public void updateStatus(String id, boolean status) throws SQLException;
    public Optional<Quote> getQuote(String id) throws SQLException;
}
