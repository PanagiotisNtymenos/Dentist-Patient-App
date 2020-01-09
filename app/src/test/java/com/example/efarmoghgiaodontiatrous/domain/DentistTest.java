package com.example.efarmoghgiaodontiatrous.domain;

import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.ConnectionState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * The type Dentist test.
 */
public class DentistTest {
    /**
     * The Dentist.
     */
    Dentist dentist;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        dentist = new Dentist("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", "ABC123", "Athens University of Economics and Business", new Address("Artis", "23", "Athens", "Greece", 17124), 13, "asd123");
        dentist.addService(new Service("Filling", "1"));
        dentist.addSpecialization(new Specialization("Pododontic", "4"));
    }

    /**
     * Test equals object.
     */
    @Test
    public void testEqualsObject() {
        Dentist dentist2 = new Dentist(dentist);
        Dentist dentist3 = new Dentist("Giorgos", "Patrikis", "6958687888", "geopatrikis12@gmail.com", "ABC123456", "AUEB", new Address("Lesvou", "8-10", "Athens", "Greece", 15127), 9, "abc123456");
        Dentist dentist4 = new Dentist(null, null, null, null, null, null, null, 0, null);
        assertFalse(dentist.equals(null));

        assertTrue(dentist2.equals(dentist));
        assertEquals(dentist2.hashCode(), dentist.hashCode());

        assertFalse(dentist3.equals(dentist));
        assertNotEquals(dentist3.hashCode(), dentist.hashCode());

        assertEquals(0, dentist4.hashCode());
    }

    /**
     * Test specializations.
     */
    @Test
    public void testSpecializations() {
        Dentist dentist = new Dentist();
        Specialization specialization = new Specialization("Orthodontic", "4");
        assertFalse(dentist.getSpecializations().contains(new Specialization("Orthodontic", "4")));
        dentist.addSpecialization(specialization);
        assertTrue(dentist.getSpecializations().contains(new Specialization("Orthodontic", "4")));
        dentist.removeSpecialization(specialization);
        assertFalse(dentist.getSpecializations().contains(new Specialization("Orthodontic", "4")));
    }

    /**
     * Test services.
     */
    @Test
    public void testServices() {
        Dentist dentist = new Dentist();
        Service service = new Service("Filling", "1");
        assertFalse(dentist.getServices().contains(new Service("Filling", "1")));
        dentist.addService(service);
        assertTrue(dentist.getServices().contains(new Service("Filling", "1")));
        dentist.removeService(service);
        assertFalse(dentist.getServices().contains(new Service("Filling", "1")));
    }

    /**
     * Test accept appointment.
     */
    @Test
    public void testAcceptAppointment() {
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        Appointment appointment = new Appointment("George", "Patrikis", "6986888788", dentist, calendar, 15, 30);
        assertNotEquals(appointment.getState(), AppointmentState.ACCEPTED);
        dentist.acceptAppointment(appointment);
        assertEquals(appointment.getState(), AppointmentState.ACCEPTED);
    }

    /**
     * checks if appointment is deleted
     */
    @Test
    public void testDeclineAppointment() {
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        Appointment appointment = new Appointment("George", "Patrikis", "6986888788", dentist, calendar, 22, 30);
        dentist.acceptAppointment(appointment);
        assertEquals(appointment.getState(), AppointmentState.ACCEPTED);
        assertTrue(dentist.getAppointments().contains(appointment));
        dentist.declineAppointment(appointment);
        assertFalse(dentist.getAppointments().contains(appointment));
    }

    /**
     * Test login.
     */
    @Test
    public void testLogin() {
        String email = "giorgos.fotopoulos7@gmail.com";
        String password = "asdd123";
        assertFalse(dentist.login(email, password));
        assertNotEquals(dentist.getState(), ConnectionState.CONNECTED);

        email = "giorgos.fotopoulos7@gmail.com";
        password = "asd123";
        assertTrue(dentist.login(email, password));
        assertEquals(dentist.getState(), ConnectionState.CONNECTED);
    }

    /**
     * Test get appointments.
     */
    @Test
    public void testGetAppointments() {
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        Appointment appointment = new Appointment("George", "Patrikis", "6986888788", dentist, calendar, 13, 0);
        assertTrue(dentist.getAppointments().isEmpty());
        dentist.acceptAppointment(appointment);
        assertTrue(dentist.getAppointments().contains(appointment));
        appointment = new Appointment("George", "Patrikis", "6986888788", dentist, calendar, 11, 30);
        assertFalse(dentist.getAppointments().contains(appointment));
    }

    /**
     * Test record visit.
     */
    @Test
    public void testRecordVisit() {
        assertEquals(dentist.recordVisit(null, null, dentist, null, null), null);
        Service service = new Service("Filling", "1");
        assertEquals(dentist.recordVisit(null, null, dentist, null, service), null);
        SimpleCalendar dateOfVisit = new SimpleCalendar(10, 10, 2010);
        String comments = "Comments...";
        Client client = new Client("Panagiotis", "Ntymenos", "6948554284", "panagiwths.nty@gmail.com", "17099800037");
        assertNotEquals(dentist.recordVisit(dateOfVisit, comments, dentist, client, service), null);
        Dentist dentist2 = new Dentist("George", "Patrikis", "698079sad051", "giorgos.foto7@gmail.com", "AB23", "Aths University of Economics and Business", new Address("Artis", "23", "Athens", "Greece", 17124), 13, "as123");
        dentist2.addService(new Service("Filling", "1"));
        assertEquals(dentist.recordVisit(dateOfVisit, comments, dentist2, client, service), null);
    }

    /**
     * Test create client card.
     */
    @Test
    public void testCreateClientCard() {
        String AMKA = "18059500037";

        assertEquals(dentist.createClientCard(null), null);
        assertEquals(dentist.createClientCard(AMKA).getAMKA(), "18059500037");
        assertNotEquals(dentist.createClientCard(AMKA).getAMKA(), "18059500038");
    }

    /**
     * Test getters setters.
     */
    @Test
    public void testGettersSetters() {
        Dentist other = new Dentist();
        other.setFirstName("Panagiotis");
        other.setLastName("Ntymenos");
        other.setTelephoneNo("6948554284");
        other.setEmail("panagiwths.nty@gmail.com");
        other.setExerciseLicense("QWERTY");
        other.setUniversityAttended("AUEB");
        other.setInfirmaryLocation(new Address("Lesvou", "8-10", "Athina", "Ellada", 11256));
        other.setTimeOfExperience(8);
        other.setPassword("qwerty123456");
        other.setID("-1");
        assertNotEquals("Giorgos", other.getFirstName());
        assertNotEquals("Patrikis", other.getLastName());
        assertNotEquals("6958687888", other.getTelephoneNo());
        assertNotEquals("geopatrikis12@gmail.com", other.getEmail());
        assertNotEquals("ABC123", other.getExerciseLicense());
        assertNotEquals("Athens University of Economics and Business", other.getUniversityAttended());
        assertNotEquals(new Address("Lesvou", "8-10", "Athens", "Greece", 15127), other.getInfirmaryLocation());
        assertNotEquals(9, other.getTimeOfExperience());
        assertNotEquals("abc123", other.getPassword());
        assertEquals("-1", other.getID());
    }

    /**
     * Test print specializations.
     */
    @Test
    public void testPrintSpecializations() {
        String str = dentist.printSpecializations();
        assertNotEquals("0", str.length());
    }

    /**
     * Test print services.
     */
    @Test
    public void testPrintServices() {
        String str = dentist.printServices();
        assertNotEquals("0", str.length());
    }
}