package main.java.com.batiCuisine.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean handleDate(String date) {
        LocalDate parsedDate = fromDateString(date);
        return parsedDate != null && !parsedDate.isAfter(LocalDate.now());
    }

    public static String toDateString(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(formatter);
    }

    public static LocalDate fromDateString(String date) {
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
