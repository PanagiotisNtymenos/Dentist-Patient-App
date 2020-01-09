package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewSchedule;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type View schedule presenter test.
 */
public class ViewSchedulePresenterTest {
    /**
     * The Presenter.
     */
    ViewSchedulePresenter presenter;
    /**
     * The View.
     */
    ViewScheduleViewStub view;
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

        view = new ViewScheduleViewStub();
        presenter = new ViewSchedulePresenter(view);
    }

    /**
     * tests the welcome message
     */
    @Test
    public void onWelcomeTest() {
        Assert.assertEquals(presenter.onWelcome("6"), "Welcome Dr. " + dentistDao.find("6").getLastName() + "!\nHere you can see the appointments you have: ");
    }

    /**
     * tests tje messages that the programm returns onSchedule
     */
    @Test
    public void onScheduleTest() {
        Assert.assertEquals(presenter.onSchedule("6"), "You have no appointments :(");
        Appointment app = new Appointment("Leuterakis", "Patrikis", "+30 698 111 1111", dentistDao.find("6"), new SimpleCalendar(2020, 5, 22), 15, 30);
        appointmentDao.clear();
        app.setState(AppointmentState.ACCEPTED);
        appointmentDao.save(app);
        Assert.assertEquals(presenter.onSchedule("6"), "Date: 22/5/2020 \nTime: 15:30 \nName: Patrikis Leuterakis \nPhone: +30 698 111 1111 \n \n");
    }
}