package main.java.com.batiCuisine.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mapper {

    private static final Logger logger = Logger.getLogger(Mapper.class.getName());

    private static <S, T> void copyFields(S source, T target) throws IllegalAccessException {
        for (Field sourceField : source.getClass().getDeclaredFields()) {
            sourceField.setAccessible(true);
            try {
                Field targetField = target.getClass().getDeclaredField(sourceField.getName());
                targetField.setAccessible(true);
                targetField.set(target, sourceField.get(source));
            } catch (NoSuchFieldException ignored) {
                logger.log(Level.FINE, "Field not found: {0}", sourceField.getName());
            }
        }
    }

    // Map entity to DTO
    public static <T, D> D mapToDto(T entity, Class<D> dtoClass) {
        try {
            D dto = dtoClass.getDeclaredConstructor().newInstance();
            copyFields(entity, dto);
            logger.info("Mapping entity to DTO successful.");
            return dto;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Mapping to DTO failed: " + e.getMessage(), e);
            return null;
        }
    }

    // Map DTO to entity
    public static <T, D> T mapToEntity(D dto, Class<T> entityClass) {
        try {
            T entity = entityClass.getDeclaredConstructor().newInstance();
            copyFields(dto, entity);
            logger.info("Mapping DTO to entity successful.");
            return entity;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Mapping to Entity failed: " + e.getMessage(), e);
            return null;
        }
    }

}
