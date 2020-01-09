package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * The type Dentist search presenter test.
 */
public class DentistSearchPresenterTest {
    /**
     * The Presenter.
     */
    DentistSearchPresenter presenter;
    /**
     * The View.
     */
    DentistSearchViewStub view;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        view = new DentistSearchViewStub();
        presenter = new DentistSearchPresenter(view);
    }

    /**
     * This method tests the searchDentists(String, String) method.
     */
    @Test
    public void testSearchDentists() {
        Set<Dentist> dentists = presenter.searchDentists("Fotopoulos", "George");
        Assert.assertNotEquals(2, dentists.size());
    }

    /**
     * This method tests the searchDentistsWithFilters(String, String, String) method.
     */
    @Test
    public void testSearchDentistsWithFilters() {
        Set<Dentist> dentistsF = presenter.searchDentistsWithFilters("Athens", "Orthodontic", "Filling");
        Assert.assertNotEquals(2, dentistsF.size());
    }

    /**
     * This method tests the onDentistSelected(Dentist) method
     */
    @Test
    public void testOnDentistSelected() {
        Set<Dentist> dentists = presenter.searchDentists("Fotopoulos", "George");
        Dentist selected = dentists.iterator().next();
        presenter.onDentistSelected(selected);
        Assert.assertNotEquals(selected.getAppointments(), view.getRequestAppointment());
    }
}