package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

/**
 * The interface Dentist search view.
 */
public interface DentistSearchView {
    /**
     * Gives the Dentist object ID as extra to the new intent.
     *
     * @param item Dentist object
     */
    void requestAppointment(Dentist item);
}