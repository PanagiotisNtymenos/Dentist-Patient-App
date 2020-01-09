package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistLogin;

import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Dentist login presenter test.
 */
public class DentistLoginPresenterTest {
    /**
     * The Presenter.
     */
    DentistLoginPresenter presenter;
    /**
     * The View.
     */
    DentistLoginViewStub view;
    /**
     * The Dentist dao.
     */
    DentistDAO dentistDao;
    /**
     * The Dentist.
     */
    Dentist dentist;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        dentistDao = new DentistDAOMemory();

        view = new DentistLoginViewStub();
        presenter = new DentistLoginPresenter(view);
    }

    /**
     * This method tests the onValid(String, String) method.
     */
    @Test
    public void testOnValid() {
        dentist = presenter.onValid("fotakis@gmail.com", "asdfg123");
        Assert.assertNotNull(dentist);
        dentist = presenter.onValid("fotakis@gmail.com", "asdfgh123");
        Assert.assertNull(dentist);
    }

    /**
     * This method tests the onResult(String) method.
     */
    @Test
    public void testOnResult() {
        String message, email;
        dentist = dentistDao.find("6");
        email = dentist.getEmail();
        message = presenter.onResult(email);
        Assert.assertNotEquals("Invalid input on the E-mail field!", message);
        email += ".";
        message = presenter.onResult(email);
        Assert.assertEquals("Invalid input on the E-mail field!", message);
    }
}