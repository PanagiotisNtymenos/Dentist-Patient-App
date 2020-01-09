package com.example.efarmoghgiaodontiatrous.domain;

import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The type Appointment test.
 */
public class AppointmentTest {
    /**
     * The Appointment.
     */
    Appointment appointment;
    /**
     * The Dentist.
     */
    Dentist dentist;
    /**
     * The Calendar.
     */
    SimpleCalendar calendar;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        calendar = new SimpleCalendar(10, 10, 2010);
        dentist = new Dentist();
        dentist.setEmail("newEmail@gmail.com");
        dentist.setPassword("newPassword");
        appointment = new Appointment("George", "Patrikis", "6986888788", dentist, calendar, 13, 0);
    }

    /**
     * Equals.
     */
    @Test
    public void equals() {
        Appointment other = new Appointment("George", "Fotopoulos", "6980793051", dentist, calendar, 13, 0);
        assertEquals(other, appointment);
        assertEquals(other.hashCode(), appointment.hashCode());
    }

    /**
     * checks Equals
     */
    @Test
    public void differentAppointments() {
        Dentist dentist2 = new Dentist();
        Appointment appointment2 = new Appointment("George", "Fotopoulos", "6980793051", dentist2, new SimpleCalendar(1, 1, 2010), 15, 30);
        dentist2.setEmail("abc123@gmail.com");
        dentist2.setPassword("abc123");

        assertNotEquals(appointment2, appointment);
        assertNotEquals(appointment2.hashCode(), appointment.hashCode());

        Appointment appointment4 = new Appointment(appointment);
        assertEquals(appointment4.hashCode(), appointment.hashCode());
    }

    /**
     * Test getters setters.
     */
    @Test
    public void testGettersSetters() {
        Appointment other = new Appointment();
        Dentist d = new Dentist();
        d.setEmail("test@gmail.com");
        d.setPassword("testPassword");
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        other.setFirstName("George");
        other.setLastName("Fotopoulos");
        other.setTelephoneNo("6980793051");
        other.setEmail("giorgos.fotopoulos7@gmail.com");
        other.setState(AppointmentState.PENDING);
        other.setDentist(dentist);
        other.setBookDate(calendar);
        other.setHour(9);
        other.setMinutes(0);
        assertNotEquals("Panagiotis", other.getFirstName());
        assertNotEquals("Ntymenos", other.getLastName());
        assertNotEquals("6948554284", other.getTelephoneNo());
        assertNotEquals("panagiwths.nty@gmail.com", other.getEmail());
        assertNotEquals(AppointmentState.ACCEPTED, other.getState());
        assertNotEquals(d, other.getDentist());
        assertNotEquals(new SimpleCalendar(1, 1, 2001), other.getBookDate());
        assertNotEquals("10", other.getHour());
    }
}