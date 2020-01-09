package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Dentist search presenter.
 */
public class DentistSearchPresenter {
    private DentistSearchView view;

    /**
     * Instantiates a new Dentist search presenter.
     *
     * @param view the view
     */
    public DentistSearchPresenter(DentistSearchView view) {
        this.view = view;
    }

    /**
     * This method searches for Dentists that meet the criteria of the fields given as parameters and returns
     * a Set that contains them.
     *
     * @param lastName  Dentists' last name
     * @param firstName Dentists' first name
     * @return Set that contains the Dentist(s) that fulfil the criteria given as parameters
     */
    public Set<Dentist> searchDentists(String lastName, String firstName) {
        Set<Dentist> result = new HashSet<>();
        List<Dentist> resultA;
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();
        resultA = dDAOMemory.findByName(lastName, firstName);
        result.addAll(resultA);
        return result;
    }

    /**
     * This method calls the requestAppointment method for the Dentist object that was selected from the list.
     *
     * @param item Dentist object
     */
    public void onDentistSelected(Dentist item) {
        view.requestAppointment(item);
    }

    /**
     * This method searches for Dentists that meet the criteria of the fields given as parameters and returns
     * a Set that contains them.
     *
     * @param region         Dentists' infirmary city location
     * @param specialization Dentists' specialization
     * @param service        Dentists' service
     * @return Set that contains the Dentist(s) that fulfil the criteria given as parameters
     */
    public Set<Dentist> searchDentistsWithFilters(String region, String specialization, String service) {
        Set<Dentist> result = new HashSet<>();
        List<Dentist> resultA;
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();
        resultA = dDAOMemory.findWithFilters(region, specialization, service);
        result.addAll(resultA);
        return result;
    }
}