package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistLogin;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

/**
 * The type Dentist login presenter.
 */
public class DentistLoginPresenter {
    /**
     * The View.
     */
    protected DentistLoginView view;

    /**
     * Instantiates a new Dentist login presenter.
     *
     * @param view the view
     */
    public DentistLoginPresenter(DentistLoginView view) {
        this.view = view;
    }

    /**
     * This method validates the email and password fields given as parameters and checks if they
     * match any Dentist on the DentistDAO. Returns the Dentist object if there is a match.
     *
     * @param email    Dentist's email
     * @param password Dentist's password
     * @return Dentist object that matches the email & password given as parameters or null
     */
    public Dentist onValid(String email, String password) {
        DentistDAOMemory dentistDao = new DentistDAOMemory();
        if (dentistDao.findByEmail(email) != null) {
            if (password.equals(dentistDao.findByEmail(email).getPassword())) {
                return dentistDao.findByEmail(email);
            }
        }
        return null;
    }

    /**
     * This method informs the Dentist in case the e-mail or password field has invalid input.
     *
     * @param email Dentist's email
     * @return A message that informs the user about either the e-mail or the password field having invalid input
     */
    public String onResult(String email) {
        DentistDAOMemory dentistDao = new DentistDAOMemory();
        if (dentistDao.findByEmail(email) == null) {
            return "Invalid input on the E-mail field!";
        }
        return "Invalid input on the Password field!";
    }
}