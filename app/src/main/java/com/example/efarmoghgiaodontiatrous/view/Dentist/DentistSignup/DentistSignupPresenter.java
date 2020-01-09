package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;

import java.util.List;

/**
 * The type Dentist signup presenter.
 */
public class DentistSignupPresenter {

    /**
     * The View.
     */
    protected DentistSignupView view;

    /**
     * Αρχικοποιεί τον Presenter.
     *
     * @param view Ένα instance του view
     */
    public DentistSignupPresenter(DentistSignupView view) {
        this.view = view;
    }

    /**
     * finds all the objects from the DAOMemory
     *
     * @return a string from each Object (Specialization)
     */
    public String[] getSpecializationList() {
        SpecializationDAOMemory sp = new SpecializationDAOMemory();
        String[] out = new String[sp.findAll().size()];
        List<Specialization> spec = sp.findAll();
        for (int i = 0; i < spec.size(); i++) {
            out[i] = spec.get(i).getSpecializationName();
        }
        return out;
    }

    /**
     * finds all the objects from the DAOMemory
     *
     * @return a string from each Object (Services)
     */
    public String[] getService() {
        ServiceDAOMemory sp = new ServiceDAOMemory();
        String[] out = new String[sp.findAll().size()];
        List<Service> spec = sp.findAll();
        for (int i = 0; i < spec.size(); i++) {
            out[i] = spec.get(i).getServiceName();
        }
        return out;
    }

    /**
     * Save dentist.
     *
     * @param d Dentist to be saved in the DAOMemory
     */
    public void saveDentist(Dentist d) {
        DentistDAOMemory DAO = new DentistDAOMemory();
        DAO.save(d);
    }

    /**
     * search in the dentistDAOMemory
     *
     * @return number of all Dentists in System
     */
    public String getDentistSize() {
        DentistDAOMemory DAO = new DentistDAOMemory();
        return (DAO.findAll().size() + "");
    }

    /**
     * From a List of Strings that are selected in programm, addSpecializations checks if the string is in DAO
     *
     * @param tempSpecialization List<String> with names of Specialization
     * @param dentist            to be add Specializations
     */
    public void addSpecializations(List<String> tempSpecialization, Dentist dentist) {
        SpecializationDAOMemory DAO = new SpecializationDAOMemory();
        List<Specialization> temp = DAO.findAll();
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < tempSpecialization.size(); j++) {
                if (tempSpecialization.get(j).equals(temp.get(i).getSpecializationName())) {
                    dentist.addSpecialization(temp.get(i));
                    break;
                }
            }
        }
    }

    /**
     * From a List of Strings that are selected in programm, addServices checks if the string is in DAO
     *
     * @param tempServices List<String> with names of Services
     * @param dentist      to be add Services
     */
    public void addServices(List<String> tempServices, Dentist dentist) {
        ServiceDAOMemory DAO = new ServiceDAOMemory();
        List<Service> temp = DAO.findAll();
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < tempServices.size(); j++) {
                if (tempServices.get(j).equals(temp.get(i).getServiceName())) {
                    dentist.addService(temp.get(i));
                    break;
                }
            }
        }
    }
}