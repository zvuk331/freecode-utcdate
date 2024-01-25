package kz.freecode.utcdate;

import kz.freecode.utcdate.format.DateFormats;
import kz.freecode.utcdate.parser.DateParser;
import kz.freecode.utcdate.parser.impl.DateParserImpl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UTCDate extends Date {

    private ZonedDateTime dateTime;
    private String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private final ZoneId UTC_ZONE_ID = ZoneId.of("UTC");

    public UTCDate() {
        this.dateTime = ZonedDateTime.now(UTC_ZONE_ID);
    }

    public UTCDate(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
        this.dateTime = ZonedDateTime.now(UTC_ZONE_ID);
    }

    public UTCDate(Date date) {
        this.dateTime = date.toInstant().atZone(UTC_ZONE_ID);
    }

    public UTCDate(ZonedDateTime date) {
        this.dateTime = date;
    }

    public UTCDate(ZonedDateTime date, String format) {
        this.dateTime = date;
        this.dateTimeFormat = format;
    }

    public static UTCDate of(String date) {
        DateParser dateParser = new DateParserImpl();
        ZonedDateTime parsedDate = dateParser.toZonedDateTime(date);
        String format = DateFormats.parse(date);
        return new UTCDate(parsedDate, format);
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    public ZoneId getZoneId() {
        return dateTime.getZone();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        return dateTime.format(formatter);
    }

}
