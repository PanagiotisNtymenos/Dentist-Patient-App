package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * The type Guest menu presenter test.
 */
public class GuestMenuPresenterTest {
    /**
     * The Presenter.
     */
    GuestMenuPresenter presenter;
    /**
     * The View.
     */
    GuestMenuViewStub view;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        view = new GuestMenuViewStub();
        presenter = new GuestMenuPresenter(view);
    }

    /**
     * This method tests the getSpecializations() method.
     */
    @Test
    public void testSpecializations() {
        List<Specialization> specializations = presenter.getSpecializations();
        Assert.assertEquals(4, specializations.size());
    }

    /**
     * This method tests the getServices() method.
     */
    @Test
    public void testServices() {
        List<Service> services = presenter.getServices();
        Assert.assertEquals(3, services.size());
    }

    /**
     * This method tests the searchByName(String, String) method.
     */
    @Test
    public void testSearchByName() {
        presenter.searchByName("", "");
        Assert.assertNull(view.getFirstName());
        presenter.searchByName("Fotopoulos", "George");
        Assert.assertEquals("Fotopoulos", view.getLastName());
    }

    /**
     * This method tests the searchByFilters(String, String, String) method.
     */
    @Test
    public void testSearchByFilters() {
        presenter.searchByFilters("", "", "");
        Assert.assertNull(view.getRegion());
        presenter.searchByFilters("Nea Smyrni", "Orthodontic", "Filling");
        Assert.assertEquals("Nea Smyrni", view.getRegion());
    }
}