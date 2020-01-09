package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.util.Address;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Dentist update account presenter test.
 */
public class DentistUpdateAccountPresenterTest {
    /**
     * The Presenter.
     */
    DentistUpdateAccountPresenter presenter;
    /**
     * The View.
     */
    DentistUpdateAccountViewStub view;
    /**
     * The D.
     */
    Dentist d;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        d = new Dentist("Giorgos", "Fotakis", "+30 698 907 3105", "fotakis@gmail.com", "191223", "Athens University of Economics and Business", new Address("Artis", "22", "Faliro", "Greece", 23124), 9, "asdfg123");

        view = new DentistUpdateAccountViewStub();
        presenter = new DentistUpdateAccountPresenter(view);
    }

    /**
     * Tests if it Passes onDentistMenu
     */
    @Test
    public void onDentistMenuTest() {
        presenter.onDentistMenu();
    }

    /**
     * Checks if First Name of d is PAOKARAS
     * After update it is
     */
    @Test
    public void onUpdateTest() {
        Assert.assertNotEquals(d.getFirstName(), "PAOKARAS");
        d.setFirstName("PAOKARAS");
        presenter.onUpdate(d);
        Assert.assertEquals(d.getFirstName(), "PAOKARAS");
    }

    /**
     * checks if getSpecializations returns an empty List
     */
    @Test
    public void getSpecializationListTest() {
        Assert.assertTrue(presenter.getSpecializationList().length != 0);
    }

    /**
     * checks if getService returns an empty List
     */
    @Test
    public void getServiceTest() {
        Assert.assertTrue(presenter.getService().length != 0);
    }

    /**
     * checks if Dentist of LoggedIn matches the one it should
     */
    @Test
    public void OnLoggedInDentistTest() {
        Assert.assertEquals(presenter.onLoggedInDentist("6").getEmail(), d.getEmail());
    }

    /**
     * Adds the Specializations that the Dentists has
     * if not in Dao it should not pass as a service
     */
    @Test
    public void addSpecializationsTest() {
        int oldSize, newSize;
        List<String> specializationsToBeAdded = new ArrayList<>();
        specializationsToBeAdded.add("Pododontic");
        oldSize = d.getSpecializations().size();
        presenter.addSpecializations(specializationsToBeAdded, d);
        newSize = d.getSpecializations().size();
        Assert.assertNotEquals(oldSize, newSize);
        presenter.addSpecializations(specializationsToBeAdded, d);
        oldSize = d.getSpecializations().size();
        Assert.assertEquals(oldSize, newSize);
    }

    /**
     * Adds Services that the Dentists provide
     * if not in Dao it should not pass as a service
     */
    @Test
    public void addServicesTest() {
        int oldSize, newSize;
        List<String> servicesToBeAdded = new ArrayList<>();
        servicesToBeAdded.add("Dental cleaning");
        oldSize = d.getServices().size();
        presenter.addServices(servicesToBeAdded, d);
        newSize = d.getServices().size();
        Assert.assertNotEquals(oldSize, newSize);
        servicesToBeAdded.add("Fake Service that shouldn't be added");
        presenter.addServices(servicesToBeAdded, d);
        oldSize = d.getServices().size();
        Assert.assertEquals(oldSize, newSize);
    }
}