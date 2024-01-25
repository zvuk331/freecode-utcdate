package kz.freecode.utcdate;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Tests {

    @Test
    public void createUTCDate() {
        UTCDate utcDate = new UTCDate();
        assertEquals("UTC", utcDate.getZoneId().getId());
    }

    @Test
    public void getDateTimeFormat() {
        UTCDate utcDate = new UTCDate();
        assertEquals("yyyy-MM-dd'T'HH:mm:ss'Z'", utcDate.getDateTimeFormat());
    }

    @Test
    public void getDateTimeFormat_when_set_in_the_constructor() {
        UTCDate utcDate = new UTCDate("yyyy/MM/dd");
        assertEquals("yyyy/MM/dd", utcDate.getDateTimeFormat());
    }

    @Test
    public void getDateTimeFormat_when_set_in_the_setter() {
        UTCDate utcDate = new UTCDate("yyyy/MM/dd");
        utcDate.setDateTimeFormat("EEE, dd MMM yyyy");
        assertEquals("EEE, dd MMM yyyy", utcDate.getDateTimeFormat());
    }

    @Test
    public void utcDateToString() {
        UTCDate utcDate = new UTCDate();
        assertNotNull(utcDate.toString());
    }

    @Test
    public void testOf() {
        UTCDate utcDate = UTCDate.of("19-09-2023");
        assertNotNull(utcDate);
        assertEquals("dd-MM-yyyy", utcDate.getDateTimeFormat());
    }

}
