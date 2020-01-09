package com.example.efarmoghgiaodontiatrous.view.Dentist.RecordService;

import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Record service presenter test.
 */
public class RecordServicePresenterTest {
    /**
     * The Presenter.
     */
    RecordServicePresenter presenter;
    /**
     * The View.
     */
    RecordServiceViewStub view;
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

        dentistDao = new DentistDAOMemory();
        serviceDao = new ServiceDAOMemory();
        visitDao = new VisitDAOMemory();
        clientDao = new ClientDAOMemory();

        view = new RecordServiceViewStub();
        presenter = new RecordServicePresenter(view);
    }

    /**
     * Tests if Null on a client that is not in System else finds the client
     */
    @Test
    public void testOnSearchClient() {
        Assert.assertNull(presenter.onSearchClient("17099800036"));
        Assert.assertNotNull(presenter.onSearchClient("17099800037"));
    }

    /**
     * tests if onCreate creates correct Visits and saves them as wanted
     */
    @Test
    public void testOnCreate() {
        int initialVisitDaoSize, newVisitDaoSize, initialClientDaoSize, newClientDaoSize;
        List<String> services = new ArrayList<>();
        for (Service service : serviceDao.findAll()) {
            services.add(service.getServiceName());
        }
        initialVisitDaoSize = visitDao.findAll().size();
        initialClientDaoSize = clientDao.findAll().size();
        presenter.onCreate(new SimpleCalendar(2019, 5, 25), "George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", "18059500037", services, dentistDao.find("6").getID(), "Test Object");
        newVisitDaoSize = visitDao.findAll().size();
        newClientDaoSize = clientDao.findAll().size();
        Assert.assertNotEquals(initialVisitDaoSize, newVisitDaoSize);
        Assert.assertNotEquals(initialClientDaoSize, newClientDaoSize);
        initialVisitDaoSize = newVisitDaoSize;
        presenter.onCreate(new SimpleCalendar(2019, 5, 26), "Giorgos", "Fwtopoulos", "6980793052", "georgefotopoulos@outlook.com", "17099800037", services, dentistDao.find("6").getID(), "Test Object");
        newVisitDaoSize = visitDao.findAll().size();
        Assert.assertNotEquals(initialVisitDaoSize, newVisitDaoSize);
    }

    /**
     * test if getService() returns the desired outcome
     */
    @Test
    public void testGetService() {
        String[] service = presenter.getService();
        Assert.assertFalse(service.length == 0);
    }
}