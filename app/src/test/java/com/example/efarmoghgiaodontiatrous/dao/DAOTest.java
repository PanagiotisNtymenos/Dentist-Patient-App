package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Dao test.
 */
public class DAOTest {
    private static final int INITIAL_APPOINTMENT_COUNT = 8;
    private static final int INITIAL_CLIENT_COUNT = 2;
    private static final int INITIAL_DENTIST_COUNT = 9;
    private static final int INITIAL_SERVICE_COUNT = 3;
    private static final int INITIAL_SPECIALIZATION_COUNT = 4;
    private static final int INITIAL_VISIT_COUNT = 6;
    private AppointmentDAO appointmentDao;
    private ClientDAO clientDao;
    private DentistDAO dentistDao;
    private ServiceDAO serviceDao;
    private SpecializationDAO specializationDao;
    private VisitDAO visitDao;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        appointmentDao = new AppointmentDAOMemory();
        clientDao = new ClientDAOMemory();
        dentistDao = new DentistDAOMemory();
        serviceDao = new ServiceDAOMemory();
        specializationDao = new SpecializationDAOMemory();
        visitDao = new VisitDAOMemory();
    }

    /**
     * Test dentists.
     */
    @Test
    public void testDentists() {
        Dentist dentist = new Dentist("Athanasios", "Fotopoulos", "+30 699 888 7766", "ath.fotopoulos7@gmail.com", "Athens:171223", "None", new Address("Artis", "23", "Athens", "Greece", 17124), 10, "asdfg123");
        dentistDao.save(dentist);
        Assert.assertNotEquals(INITIAL_DENTIST_COUNT, dentistDao.findAll().size());
        Dentist d = dentistDao.findByEmail("ath.fotopoulos7@gmail.com");
        Dentist d1 = dentistDao.findByEmail("test@gmail.com");
        Assert.assertNull(d1);
        dentistDao.delete(d);
        dentistDao.delete(dentist);
        d1 = dentistDao.find("1555");
        Assert.assertNull(d1);

        List<Dentist> nullName = dentistDao.findByName("Fotopoulos", null);
        Assert.assertNotEquals(null, nullName.get(0).getFirstName());

        List<Dentist> nullSurname = dentistDao.findByName("", "George");
        Assert.assertNull(nullSurname);

        List<Dentist> properNames = dentistDao.findByName("Fotopoulos", "George");
        Assert.assertEquals("Fotopoulos", properNames.get(0).getLastName());
        Assert.assertEquals("George", properNames.get(0).getFirstName());

        List<Dentist> dentistsAthens = dentistDao.findWithFilters("Athens", "Pedodontic", "Filling");
        List<Dentist> dentistsAghiosDimitrios = dentistDao.findWithFilters("Aghios Dimitrios", "Endodontic", "Teeth whitening");
        Assert.assertEquals(dentistsAthens, dentistsAghiosDimitrios);

        List<Dentist> dentistsNoSpecialization = dentistDao.findWithFilters("Athens", "", "Filling");
        Assert.assertTrue(dentistsNoSpecialization.isEmpty());

        List<Dentist> dentistsNoSpecializationRegion = dentistDao.findWithFilters("", "", "Dental cleaning");
        Assert.assertNotEquals("Aghios Dimitrios", dentistsNoSpecializationRegion.get(0).getInfirmaryLocation().getCity());

        List<Dentist> dentistsNoServiceRegion = dentistDao.findWithFilters("", "Orthodontic", "");
        Assert.assertNotEquals("Athens", dentistsNoServiceRegion.get(0).getInfirmaryLocation().getCity());

        List<Dentist> dentistsNoRegion = dentistDao.findWithFilters("", "Orthodontic", "Dental cleaning");
        Assert.assertNotEquals("Athens", dentistsNoRegion.get(0).getInfirmaryLocation().getCity());

        List<Dentist> dentistsNoSpecializationService = dentistDao.findWithFilters("Aghios Dimitrios", "", "");
        Assert.assertNotEquals("Filling", dentistsNoSpecializationService.get(0).getServices());

        List<Dentist> dentistsNoService = dentistDao.findWithFilters("Aghios Dimitrios", "Pedodontic", "");
        Assert.assertTrue(dentistsNoService.isEmpty());

        List<Dentist> dentistNullFilters = dentistDao.findWithFilters(null, null, null);
        Assert.assertNull(dentistNullFilters);

        Dentist dent = dentistDao.findByEmail("fotakis@gmail.com");
        Assert.assertNotNull(dent);
        dent = dentistDao.findByEmail("patrikakis@gmail.com");
        Assert.assertNull(dent);

        List<Dentist> test1 = dentistDao.findWithFilters("Peristeri", "", "Teeth whitening");
        Assert.assertFalse(test1.isEmpty());

        test1 = dentistDao.findWithFilters("Peristeri", "", "Root canal");
        Assert.assertTrue(test1.isEmpty());

        List<Dentist> test2 = dentistDao.findWithFilters("Peristeri", "Orthodontic", "");
        Assert.assertFalse(test2.isEmpty());

        test2 = dentistDao.findWithFilters("Peristeri", "Pododontic", "");
        Assert.assertTrue(test2.isEmpty());

        List<Dentist> test3 = dentistDao.findWithFilters("Peristeri", "Pedodontic", "Teeth whitening");
        Assert.assertFalse(test3.isEmpty());
    }

    /**
     * Test clients.
     */
    @Test
    public void testClients() {
        Client client = new Client("Gioris", "Ntymenos", "+30 698 468 9046", "geo.nty@gmail.com", "17099600037");
        clientDao.save(client);
        Assert.assertNotEquals(INITIAL_CLIENT_COUNT, clientDao.findAll().size());
        clientDao.delete(client);
        Client client1 = clientDao.find("17099800037");
        Assert.assertEquals("17099800037", client1.getAMKA());
        Client client2 = clientDao.find("18059500037");
        Assert.assertNull(client2);
    }

    /**
     * Test appointments.
     */
    @Test
    public void testAppointments() {
        Appointment appointment = new Appointment("Georgios", "Patrikis", "+30 697 111 1111", dentistDao.find("1"), new SimpleCalendar(2019, 28, 6), 15, 30);
        appointmentDao.save(appointment);
        appointmentDao.save(appointment);
        Assert.assertNotEquals(INITIAL_APPOINTMENT_COUNT, appointmentDao.findAll().size());
        appointmentDao.delete(appointment);
        List<Appointment> appointmentList;
        appointmentList = appointmentDao.find(dentistDao.find("1500"), AppointmentState.PENDING);
        Assert.assertTrue(appointmentList.isEmpty());
        appointmentList = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING);
        Assert.assertFalse(appointmentList.isEmpty());
    }

    /**
     * Test services.
     */
    @Test
    public void testServices() {
        Service service = new Service("Root canal", serviceDao.nextId());
        serviceDao.save(service);
        Assert.assertNotEquals(INITIAL_SERVICE_COUNT, serviceDao.findAll().size());
        serviceDao.delete(service);
        Service service1 = serviceDao.find("4");
        Assert.assertNull(service1);
    }

    /**
     * Test specializations.
     */
    @Test
    public void testSpecializations() {
        Specialization specialization = new Specialization("Periodontic", specializationDao.nextId());
        specializationDao.save(specialization);
        Assert.assertNotEquals(INITIAL_SPECIALIZATION_COUNT, specializationDao.findAll().size());
        specializationDao.delete(specialization);
        specialization = specializationDao.find("5");
        Assert.assertNull(specialization);
    }

    /**
     * Test visits.
     */
    @Test
    public void testVisits() {
        Set<Service> servicesProvided = new HashSet<>();
        servicesProvided.add(serviceDao.find("1"));
        Visit visit = new Visit(new SimpleCalendar(2018, 5, 18), "Operation unsuccessful!", dentistDao.find("2"), clientDao.find("17090000037"), servicesProvided);
        visitDao.save(visit);
        Assert.assertNotEquals(INITIAL_VISIT_COUNT, visitDao.findAll().size());
        visitDao.delete(visit);
        List<Visit> visitList;
        visitList = visitDao.find("17099800037");
        Assert.assertEquals("17099800037", visitList.get(0).getClient().getAMKA());
        visitList = visitDao.find("18059500037");
        Assert.assertNotNull(visitList);
    }
}