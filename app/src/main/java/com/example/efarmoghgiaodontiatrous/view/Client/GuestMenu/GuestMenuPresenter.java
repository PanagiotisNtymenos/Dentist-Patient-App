package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;

import java.util.List;

/**
 * The type Guest menu presenter.
 */
public class GuestMenuPresenter {
    private GuestMenuView view;

    /**
     * Initializes the Presenter.
     *
     * @param view A view instance
     */
    public GuestMenuPresenter(GuestMenuView view) {
        this.view = view;
    }

    /**
     * This method carries out a Dentist research using the last name and first name given as parameters.
     * The last name field is required.
     *
     * @param lastName  Dentist's last name
     * @param firstName Dentist's first name
     */
    public void searchByName(String lastName, String firstName) {
        if (lastName.isEmpty() && firstName.isEmpty()) {
            view.showError("The field \"Last Name\" is not optional!");
            return;
        }
        view.showSearchView(lastName, firstName);
    }

    /**
     * Returns a List containing all the entities within the SpecializationDAO.
     *
     * @return All the Specialization entities in the SpecializationDAO
     */
    public List<Specialization> getSpecializations() {
        SpecializationDAOMemory dao = new SpecializationDAOMemory();
        return dao.findAll();
    }

    /**
     * Returns a List containing all the entities within the ServiceDAO.
     *
     * @return All the Service entities in the ServiceDAO
     */
    public List<Service> getServices() {
        ServiceDAOMemory dao = new ServiceDAOMemory();
        return dao.findAll();
    }

    /**
     * This method carries out a Dentist research using the region, specialization and service given as parameters.
     * Filling in at least one of the fields is required.
     *
     * @param region         Dentist Infirmary's city location
     * @param specialization Dentist's Specialization
     * @param service        Dentist's Service
     */
    public void searchByFilters(String region, String specialization, String service) {
        if (region.equals("") && specialization.equals("") && service.equals("")) {
            view.showError("You have to fill in at least one value!");
            return;
        }
        view.showSearchViewFilters(region, specialization, service);
    }
}