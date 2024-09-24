package main.java.com.batiCuisine.services;

import main.java.com.batiCuisine.dto.QuoteDto;
import main.java.com.batiCuisine.models.Quote;
import main.java.com.batiCuisine.repositories.interfaces.QuoteRepository;
import main.java.com.batiCuisine.services.interfaces.QuoteService;
import main.java.com.batiCuisine.utils.Mapper;

import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Logger;

public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;
    private static final Logger logger = Logger.getLogger(QuoteServiceImpl.class.getName());

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public QuoteDto addQuote(QuoteDto quote) {
        try {
            Quote quoteEntity = Mapper.mapToEntity(quote, Quote.class);
            quoteEntity = quoteRepository.addQuote(quoteEntity);
            return Mapper.mapToDto(quoteEntity, QuoteDto.class);
        } catch (SQLException e) {
            logger.severe("Error adding quote" + quote + "Error:" + e.getMessage());
            throw new RuntimeException("Unable to add quote", e);
        }
    }

    @Override
    public Optional<QuoteDto> getQuoteByProject(String projectId) {
        if (projectId == null || projectId.isEmpty()) {
            logger.warning("Project ID is invalid or empty.");
            return Optional.empty();
        }

        try {
            Optional<Quote> optionalQuote = quoteRepository.getQuoteByProject(projectId);

            return optionalQuote.map(quote -> Mapper.mapToDto(quote, QuoteDto.class));
        } catch (SQLException e) {
            logger.severe("Error fetching quote by project id" + projectId + "Error:" + e.getMessage());
            throw new RuntimeException("Unable to fetch quote by project id", e);
        }
    }

    @Override
    public void updateStatus(String id, boolean status) {
        if (id == null || id.isEmpty()) {
            logger.warning("Quote ID is invalid or empty.");
            throw new IllegalArgumentException("Quote ID is invalid or empty.");
        }

        try {
            Optional<Quote> quote = quoteRepository.getQuote(id);
            if (quote.isPresent()) {
                quoteRepository.updateStatus(id, status);
                logger.info("Updated status for quote ID: " + id + " to " + status);
            } else {
                logger.severe("Quote not found for the provided ID: " + id);
            }
        } catch (SQLException e) {
            logger.severe("Error updating quote status" + id + "Error:" + e.getMessage());
            throw new RuntimeException("Unable to update quote status", e);
        }
    }

    @Override
    public Optional<QuoteDto> getQuote(String id) {
        if (id == null || id.isEmpty()) {
            logger.severe("ID field must be filled in");
            throw new IllegalArgumentException("ID field must not be null or empty");
        }

        try {
            Optional<Quote> optionalQuote = quoteRepository.getQuote(id);

            return optionalQuote.map(quote -> Mapper.mapToDto(quote, QuoteDto.class));
        } catch (SQLException e) {
            logger.severe("Error fetching quote with ID: " + id + ". Error: " + e.getMessage());
            throw new RuntimeException("Unable to fetch quote with ID: " + id, e);
        }
    }
}
