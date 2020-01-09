package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

/**
 * The type Dentist view profile presenter.
 */
public class DentistViewProfilePresenter {

    private DentistViewProfileView view;

    /**
     * Instantiates a new Dentist view profile presenter.
     *
     * @param view the view
     */
    public DentistViewProfilePresenter(DentistViewProfileView view) {
        this.view = view;
    }

    /**
     * On update account.
     */
    public void onUpdateAccount() {
        view.updateAccount();
    }

    /**
     * This method searches the Dentist's account by his ID..
     *
     * @param ID Dentist's ID
     * @return a String with all of his information
     */
    public String onShowProfile(String ID) {
        DentistDAOMemory dentist = new DentistDAOMemory();
        Dentist d = dentist.find(ID);
        return "ID: " + ID + "\n\nName: " + d.getLastName() + " " + d.getFirstName() + "\n\nE-mail: " + d.getEmail() + "\n\nPhone Number: " +
                d.getTelephoneNo() + "\n\nLicense Number: " + d.getExerciseLicense() + "\n\nUniversity: " + d.getUniversityAttended() +
                "\n\nLocation: " + d.getInfirmaryLocation().print() + "\n\nYears of Experience: " + d.getTimeOfExperience() +
                "\n\nServices: " + d.printServices() + "\n\nSpecializations: " + d.printSpecializations();
    }
}