package kz.freecode.utcdate.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public interface DateParser {

    Date toDate(String date);
    LocalDate toLocalDate(String date);
    LocalDateTime toLocalDateTime(String date);
    ZonedDateTime toZonedDateTime(String date);
}
