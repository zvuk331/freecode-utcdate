package kz.freecode.utcdate.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DateFormats {

    public final static List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
            DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z"),
            DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"),
            DateTimeFormatter.ofPattern("EEE, dd MMM yyyy"),
            DateTimeFormatter.ofPattern("dd MMM yyyy"),
            DateTimeFormatter.ISO_DATE_TIME
    );

    public final static List<String> PATTERNS = Arrays.asList(
            "yyyy-MM-dd HH:mm:ss",
            "yyyy/MM/dd HH:mm:ss",
            "yyyy.MM.dd HH:mm:ss",
            "dd-MM-yyyy HH:mm:ss",
            "dd/MM/yyyy HH:mm:ss",
            "dd.MM.yyyy HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
            "EEE, dd MMM yyyy HH:mm:ss z",
            "EEE, dd MMM yyyy HH:mm:ss Z",
            "dd-MM-yyyy",
            "dd/MM/yyyy",
            "yyyy-MM-dd",
            "yyyy/MM/dd",
            "EEE, dd MMM yyyy",
            "dd MMM yyyy"
    );

    public static String parse(String dateString) {
        for (String format : DateFormats.PATTERNS) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            try {
                simpleDateFormat.parse(dateString);
                return format;
            } catch (ParseException e) {
                // Ignore the error and continue with following format
            }
        }
        return null;
    }

}
