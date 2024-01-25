package kz.freecode.utcdate.parser.impl;


import kz.freecode.utcdate.format.DateFormats;
import kz.freecode.utcdate.parser.DateParser;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateParserImpl implements DateParser {

    private final static int MAX_LENGTH_DATE_WITHOUT_TIME = 16;

    public Date toDate(String date) {
        return Date.from(parse(date).toInstant());
    }

    public LocalDate toLocalDate(String date) {
        return parse(date).toLocalDate();
    }

    public LocalDateTime toLocalDateTime(String date) {
        return parse(date).toLocalDateTime();
    }

    public ZonedDateTime toZonedDateTime(String date) {
        return parse(date);
    }

    private ZonedDateTime parse(String date) {
        for (DateTimeFormatter formatter : DateFormats.FORMATTERS) {
            boolean isDateWithoutTime = date.length() < MAX_LENGTH_DATE_WITHOUT_TIME;
            try {
                if (isDateWithoutTime) {
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    return ZonedDateTime.of(localDate, LocalTime.MIN, ZoneId.of("UTC"));
                }
                LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
                return localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC);
            } catch (DateTimeParseException e) {
                // We continue to search for a suitable format
            }
        }
        throw new DateTimeParseException("Unknown date format: '%s'", date, 0);
    }

}

