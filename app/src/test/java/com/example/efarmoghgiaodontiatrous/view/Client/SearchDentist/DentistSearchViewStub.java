package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

/**
 * The type Dentist search view stub.
 */
public class DentistSearchViewStub implements DentistSearchView {
    private Dentist requestAppointmentResult;

    @Override
    public void requestAppointment(Dentist item) {
        this.requestAppointmentResult = item;
    }

    /**
     * Gets request appointment.
     *
     * @return the request appointment
     */
    public Dentist getRequestAppointment() {
        return requestAppointmentResult;
    }
}