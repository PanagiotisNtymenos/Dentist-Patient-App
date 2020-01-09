package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;

/**
 * The type View statistics presenter.
 */
public class ViewStatisticsPresenter {
    /**
     * The View.
     */
    ViewStatisticsView view;

    /**
     * Instantiates a new View statistics presenter.
     *
     * @param view the view
     */
    public ViewStatisticsPresenter(ViewStatisticsView view) {
        this.view = view;
    }


    /**
     * On welcome string.
     *
     * @param ID finds the Dentist with the given ID
     * @return A welcome message
     */
    public String onWelcome(String ID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        return "Welcome Dr. " + ddao.find(ID).getLastName() + "!\nBelow is the list with all the successful operations you have made:";
    }

    /**
     * finds all the Operations that the Dentist has provided in each Service and keeps a count on it
     *
     * @param ID Dentist ID to find the stats for the specific Dentist
     * @return a String with the number og the Services or a Message that he ahs no opperations yet
     */
    public String onStats(String ID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        VisitDAOMemory vdao = new VisitDAOMemory();
        ServiceDAOMemory sdao = new ServiceDAOMemory();
        Dentist dentist = ddao.find(ID);
        String result = "";
        int times;
        boolean has = false;
        for (Service serv : sdao.findAll()) {
            times = 0;
            for (Visit visit : vdao.findAll()) {
                if (dentist.equals(visit.getDentist()) && visit.getServices().contains(new Service(serv.getServiceName(), serv.getServiceID()))) {
                    has = true;
                    times++;
                }
            }
            if (times == 1) {
                result = result + serv.getServiceName() + ": " + times + " successful operation\n";
            } else if (times != 0) {
                result = result + serv.getServiceName() + ": " + times + " successful operations\n";
            }
        }
        if (!has) {
            result = "No successful operations yet!";
        }
        return result;
    }
}