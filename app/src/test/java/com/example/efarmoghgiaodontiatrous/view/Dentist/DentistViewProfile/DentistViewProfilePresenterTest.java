package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile;

import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Dentist view profile presenter test.
 */
public class DentistViewProfilePresenterTest {
    /**
     * The Presenter.
     */
    DentistViewProfilePresenter presenter;
    /**
     * The View.
     */
    DentistViewProfileViewStub view;
    private DentistDAO dentistDao;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        dentistDao = new DentistDAOMemory();

        view = new DentistViewProfileViewStub();
        presenter = new DentistViewProfilePresenter(view);
    }

    /**
     * Shows the profile of Dentists and test that the message is as wanted
     */
    @Test
    public void onShowProfileTest() {
        Dentist d = dentistDao.find("6");
        Assert.assertEquals(presenter.onShowProfile("6"), "ID: " + d.getID() + "\n\nName: " + d.getLastName() + " " + d.getFirstName() + "\n\nE-mail: " + d.getEmail() + "\n\nPhone Number: " +
                d.getTelephoneNo() + "\n\nLicense Number: " + d.getExerciseLicense() + "\n\nUniversity: " + d.getUniversityAttended() +
                "\n\nLocation: " + d.getInfirmaryLocation().print() + "\n\nYears of Experience: " + d.getTimeOfExperience() +
                "\n\nServices: " + d.printServices() + "\n\nSpecializations: " + d.printSpecializations());

    }

    /**
     * checks if passes a test
     */
    @Test
    public void onUpdateAccountTest() {
        presenter.onUpdateAccount();
    }
}