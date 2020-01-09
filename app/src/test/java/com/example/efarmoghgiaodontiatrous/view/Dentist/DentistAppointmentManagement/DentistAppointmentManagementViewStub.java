package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

/**
 * The type Dentist appointment management view stub.
 */
public class DentistAppointmentManagementViewStub implements DentistAppointmentManagementView {
    private String message;

    @Override
    public void jobDone(String msg) {
        this.message = msg;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }
}