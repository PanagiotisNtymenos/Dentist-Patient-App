package com.example.efarmoghgiaodontiatrous.util;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * The type Simple calendar test.
 */
public class SimpleCalendarTest {
    /**
     * Creation.
     */
    @Test
    public void creation() {
        SimpleCalendar march_1_2007 = new SimpleCalendar(2007, 3, 1);
        assert1stMarch2007(march_1_2007);
    }

    /**
     * Creation form calendar.
     */
    @Test
    public void creationFormCalendar() {
        Calendar date = Calendar.getInstance();
        date.set(2007, Calendar.MARCH, 1);
        SimpleCalendar march_1_2007 = new SimpleCalendar(date);
        assert1stMarch2007(march_1_2007);
    }

    /**
     * Preserve date invirant.
     */
    @Test
    public void preserveDateInvirant() {
        SimpleCalendar date = new SimpleCalendar(2007, 2, 29);
        assert1stMarch2007(date);
    }

    /**
     * Before and after.
     */
    @Test
    public void beforeAndAfter() {
        SimpleCalendar date = new SimpleCalendar(2007, 3, 1);
        SimpleCalendar date2 = new SimpleCalendar(2007, 2, 28);
        SimpleCalendar other = new SimpleCalendar(-1, -1, -1);

        assertTrue(date.before(new SimpleCalendar(2007, 3, 2)));
        assertTrue(date.compareTo(new SimpleCalendar(2007, 3, 2)) < 0);

        assertTrue(date.after(new SimpleCalendar(2007, 2, 28)));
        assertTrue(date.compareTo(new SimpleCalendar(2007, 2, 28)) > 0);

        assertFalse(date.after(new SimpleCalendar(2007, 3, 1)));
        assertFalse(date.before(new SimpleCalendar(2007, 3, 1)));
        assertEquals(0, date.compareTo(new SimpleCalendar(2007, 3, 1)));

        assertEquals(0, other.hashCode());
        assertNotEquals(date2.hashCode(), date.hashCode());

        assertEquals("01", date.getStringDay());
        assertEquals("28", date2.getStringDay());

        SimpleCalendar testDate = new SimpleCalendar(2007, 11, 11);
        assertEquals("11", testDate.getStringMonth());
        assertEquals("03", date.getStringMonth());
    }

    /**
     * Duration.
     */
    @Test
    public void duration() {
        SimpleCalendar february_28_2007 = new SimpleCalendar(2007, 2, 28);
        SimpleCalendar march_1_2007 = new SimpleCalendar(2007, 3, 1);

        assertEquals(0, february_28_2007.durationInDays(new SimpleCalendar(2007, 2, 28)));
        assertEquals(1, february_28_2007.durationInDays(march_1_2007));
        assertEquals(-1, march_1_2007.durationInDays(february_28_2007));
    }

    private void assert1stMarch2007(SimpleCalendar date) {
        assertEquals(2007, date.getYear());
        assertEquals(3, date.getMonth());
        assertEquals(1, date.getDayOfMonth());
        assertNotEquals(1, date.getDayOfWeek());
    }
}