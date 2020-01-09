package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Dentist appointment management presenter test.
 */
public class DentistAppointmentManagementPresenterTest {
    /**
     * The Presenter.
     */
    DentistAppointmentManagementPresenter presenter;
    /**
     * The View.
     */
    DentistAppointmentManagementViewStub view;
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

        view = new DentistAppointmentManagementViewStub();
        presenter = new DentistAppointmentManagementPresenter(view);
    }

    /**
     * This method tests the getAppointments(String, AppointmentState) method.
     */
    @Test
    public void testGetAppointments() {
        String[] appointmentList = presenter.getAppointments("6", AppointmentState.PENDING);
        Assert.assertNotEquals(0, appointmentList.length);
    }

    /**
     * This method tests the acceptAppointments(String, List<String>) method.
     */
    @Test
    public void testAcceptAppointments() {
        List<String> selectedAppointments = new ArrayList<>();
        selectedAppointments.add("22/10/2016 16:00  \nPatrikis Georgios +30 698 222 2222");
        int size = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        presenter.acceptAppointments("6", selectedAppointments);
        int newSize = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        Assert.assertNotEquals(size, newSize);
    }

    /**
     * This method tests the declineAppointments(String, List<String>) method.
     */
    @Test
    public void testDeclineAppointments() {
        List<String> selectedAppointments = new ArrayList<>();
        selectedAppointments.add("22/10/2016 16:00  \nPatrikis Georgios +30 698 222 2222");
        int size = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        presenter.declineAppointments("6", selectedAppointments);
        int newSize = appointmentDao.find(dentistDao.find("6"), AppointmentState.PENDING).size();
        Assert.assertNotEquals(size, newSize);
    }
}