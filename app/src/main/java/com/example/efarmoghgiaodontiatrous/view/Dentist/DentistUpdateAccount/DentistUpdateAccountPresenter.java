package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;

import java.util.List;

/**
 * The type Dentist update account presenter.
 */
public class DentistUpdateAccountPresenter {
    private DentistUpdateAccountView view;

    /**
     * Instantiates a new Dentist update account presenter.
     *
     * @param view the view
     */
    public DentistUpdateAccountPresenter(DentistUpdateAccountView view) {
        this.view = view;
    }

    /**
     * On dentist menu.
     */
    public void onDentistMenu() {
        view.dentistMenu();
    }

    /**
     * ovverides over the old account of the existing Dentist (Keeps ID)
     *
     * @param newAccount account to be Saved
     */
    public void onUpdate(Dentist newAccount) {
        DentistDAOMemory dao = new DentistDAOMemory();
        Dentist oldAccount = dao.find(newAccount.getID());
        dao.delete(oldAccount);
        dao.save(newAccount);
    }

    /**
     * On logged in dentist dentist.
     *
     * @param ID of the Logged in Dentist
     * @return Dentist that is Logged in
     */
    public Dentist onLoggedInDentist(String ID) {
        DentistDAOMemory d = new DentistDAOMemory();
        return d.find(ID);
    }

    /**
     * Get specialization list string [ ].
     *
     * @return a String Array of  all The Specialization Names in DAO
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
     * Get service string [ ].
     *
     * @return a String Array of  all The Service Names in DAO
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
     * Save all the Specializations from the param List that exist in SpecializationDAO
     *
     * @param tempSpecialization the temp specialization
     * @param dentist            to add Specializations
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
     * Save all the Services from the param List that exist in ServiceDAO
     *
     * @param tempServices the temp services
     * @param dentist      to add Services that he can provide
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