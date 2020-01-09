package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewHistory;

import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;

import java.util.List;

/**
 * The type Dentist view history presenter.
 */
public class DentistViewHistoryPresenter {

    /**
     * The View.
     */
    protected DentistViewHistoryView view;

    /**
     * Instantiates a new Dentist view history presenter.
     *
     * @param view the view
     */
    public DentistViewHistoryPresenter(DentistViewHistoryView view) {
        this.view = view;
    }


    /**
     * Searches in the VisitDAOMemory for all the visits that were provided in the client with the AMKA in parameter
     *
     * @param AMKA of the client that we want to find all the Services that he was provided
     * @return if there are Visits to the client with the AMKA given returns a String with all the info of all the Visits
     */
    public String onHistoryBack(String AMKA) {
        VisitDAOMemory v = new VisitDAOMemory();
        List<Visit> listToString;
        listToString = v.find(AMKA);
        String services, history;
        if (listToString.isEmpty()) {
            return "There is no recorded visit history for this client!";
        } else {
            history = "Client's Name: " + listToString.get(0).getClient().getLastName() + " " + listToString.get(0).getClient().getFirstName() + "\n\n";
            for (Visit key : listToString) {
                services = "";
                for (Service s : key.getServices()) {
                    services = services + s.getServiceName() + ", ";
                }
                services = services.substring(0, services.length() - 2);
                history += "Date: " + key.getDateOfVisit().getDayOfMonth() + "/" + key.getDateOfVisit().getMonth() + "/" + key.getDateOfVisit().getYear() +
                        "\nDentist: " + key.getDentist().getLastName() + " " + key.getDentist().getFirstName() +
                        "\nServices: " + services;
                if (!key.getComments().equals("")) {
                    history += "\nComments: " + key.getComments();
                }
                history += "\n\n";
            }
        }
        return history;
    }
}