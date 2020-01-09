package com.example.efarmoghgiaodontiatrous.view.Dentist.RecordService;

import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Record service presenter.
 */
public class RecordServicePresenter {
    /**
     * The View.
     */
    RecordServiceView view;

    /**
     * Instantiates a new Record service presenter.
     *
     * @param view the view
     */
    public RecordServicePresenter(RecordServiceView view) {
        this.view = view;
    }


    /**
     * This method searches a client in the DAO, based on his AMKA.
     *
     * @param AMKA The client's AMKA
     * @return client 's  information
     */
    public Client onSearchClient(String AMKA) {
        ClientDAOMemory v = new ClientDAOMemory();
        Client client = v.find(AMKA);
        return client;
    }

    /**
     * This method creates a new Visit in the DAO.
     *
     * @param calendar  The visit's date
     * @param firstName The client's First Name
     * @param lastName  The client's Last Name
     * @param phone     The client's phone
     * @param email     The client's email
     * @param AMKA      The client's AMKA
     * @param services  The services that the Dentist provided
     * @param dentistID The Dentist's ID
     * @param comments  Possible Comments
     */
    public void onCreate(SimpleCalendar calendar, String firstName, String lastName, String phone, String email, String AMKA, List<String> services, String dentistID, String comments) {
        DentistDAOMemory dentistDao = new DentistDAOMemory();
        VisitDAOMemory visitDao = new VisitDAOMemory();
        ClientDAOMemory clientDao = new ClientDAOMemory();
        ServiceDAOMemory serviceDao = new ServiceDAOMemory();
        List<Service> allServices = serviceDao.findAll();
        Set<Service> serviceSet = new HashSet<>();

        for (int i = 0; i < allServices.size(); i++) {
            if (services.contains(allServices.get(i).getServiceName())) {
                serviceSet.add(allServices.get(i));
            }
        }

        if (onSearchClient(AMKA) != null) {
            visitDao.save(new Visit(calendar, comments, dentistDao.find(dentistID), onSearchClient(AMKA), serviceSet));
        } else {
            Client c = new Client(firstName, lastName, phone, email, AMKA);
            clientDao.save(c);
            visitDao.save(new Visit(calendar, comments, dentistDao.find(dentistID), c, serviceSet));
        }
    }

    /**
     * This method searches all the services in th DAO.
     *
     * @return an Array with all the services available
     */
    public String[] getService() {
        ServiceDAOMemory serviceDao = new ServiceDAOMemory();
        String[] out = new String[serviceDao.findAll().size()];
        List<Service> allServicesices = serviceDao.findAll();
        for (int i = 0; i < allServicesices.size(); i++) {
            out[i] = allServicesices.get(i).getServiceName();
        }
        return out;
    }
}