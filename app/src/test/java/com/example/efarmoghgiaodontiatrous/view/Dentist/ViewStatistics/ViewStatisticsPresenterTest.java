package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics;

import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * The type View statistics presenter test.
 */
public class ViewStatisticsPresenterTest {
    /**
     * The Presenter.
     */
    ViewStatisticsPresenter presenter;
    /**
     * The View.
     */
    ViewStatisticsViewStub view;
    private ClientDAO clientDao;
    private DentistDAO dentistDao;
    private ServiceDAO serviceDao;
    private VisitDAO visitDao;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        clientDao = new ClientDAOMemory();
        dentistDao = new DentistDAOMemory();
        serviceDao = new ServiceDAOMemory();
        visitDao = new VisitDAOMemory();

        view = new ViewStatisticsViewStub();
        presenter = new ViewStatisticsPresenter(view);
    }

    /**
     * Tests the welcome message
     */
    @Test
    public void onWelcomeTest() {
        Assert.assertEquals("Welcome Dr. Fotakis!\nBelow is the list with all the successful operations you have made:", presenter.onWelcome("6"));
    }

    /**
     * Checks the way that onStats return the String to be shown
     */
    @Test
    public void onStatsTest() {
        Dentist D = dentistDao.find("3");
        Set<Service> serv = new HashSet<>();
        visitDao.save(new Visit(new SimpleCalendar(2018, 6, 18), "Operation successful!", D, clientDao.find("17099800037"), serv));
        Assert.assertEquals("Filling: 1 successful operation\nDental cleaning: 1 successful operation\n", presenter.onStats("3"));
        serv.add(serviceDao.find("3"));
        visitDao.save(new Visit(new SimpleCalendar(2018, 6, 18), "Operation successful!", D, clientDao.find("17099800037"), serv));
        Assert.assertEquals("Filling: 1 successful operation\nDental cleaning: 2 successful operations\n", presenter.onStats("3"));
        visitDao.save(new Visit(new SimpleCalendar(2019, 6, 18), "Operation successful!", D, clientDao.find("17099800037"), serv));
        Assert.assertEquals("Filling: 1 successful operation\nDental cleaning: 3 successful operations\n", presenter.onStats("3"));
    }
}