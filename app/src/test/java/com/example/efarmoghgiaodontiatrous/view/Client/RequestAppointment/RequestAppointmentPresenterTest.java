package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Request appointment presenter test.
 */
public class RequestAppointmentPresenterTest {
    /**
     * The Presenter.
     */
    RequestAppointmentPresenter presenter;
    /**
     * The View.
     */
    RequestAppointmentViewStub view;
    private AppointmentDAO appointmentDao;
    private DentistDAO dentistDao;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        appointmentDao = new AppointmentDAOMemory();
        dentistDao = new DentistDAOMemory();

        view = new RequestAppointmentViewStub();
        presenter = new RequestAppointmentPresenter(view);
    }

    /**
     * This method tests the requestAppointment(Dentist, SimpleCalendar, String, String, String, String) method.
     */
    @Test
    public void testRequestAppointment() {
        Dentist d = presenter.findDentistByID("1555");
        Assert.assertNull(d);

        int size = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();

        presenter.requestAppointment(dentistDao.find("6"), null, "11:00", "6980793051", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(null, new SimpleCalendar(2009, 1, 1), "11:00", "6980793051", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "", "6980793051", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "09:00", "", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "11:00", "6980793051", "", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "22:25", "6980793051", "Fotopoulakis", "");
        presenter.requestAppointment(null, null, "", "", "", "");
        int sizeNew = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        Assert.assertEquals(size, sizeNew);

        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "11:00", "6980793051", "Fotopoulakis", "Georgios");
        sizeNew = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        Assert.assertNotEquals(size, sizeNew);

        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "22:00", "6980793051", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "20:25", "6980793051", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "08:00", "6980793051", "Fotopoulakis", "Georgios");
        size = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        Assert.assertEquals(size, sizeNew);

        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "22:000", "6980793051", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "22200", "6980793051", "Fotopoulakis", "Georgios");
        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "1a:00", "6980793051", "Fotopoulakis", "Georgios");
        sizeNew = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        Assert.assertEquals(size, sizeNew);

        presenter.requestAppointment(dentistDao.find("6"), new SimpleCalendar(2009, 1, 1), "11:00", "6980793051", "Fotopoulakis", "Georgios");
        size = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        Assert.assertEquals(size, sizeNew);
    }
}