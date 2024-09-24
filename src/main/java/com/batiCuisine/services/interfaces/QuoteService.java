package main.java.com.batiCuisine.services.interfaces;

import main.java.com.batiCuisine.dto.QuoteDto;

import java.sql.SQLException;
import java.util.Optional;

public interface QuoteService {
    public QuoteDto addQuote(QuoteDto quote);
    public Optional<QuoteDto> getQuoteByProject(String projectId);
    public void updateStatus(String id, boolean status);
    public Optional<QuoteDto> getQuote(String id) ;
}
