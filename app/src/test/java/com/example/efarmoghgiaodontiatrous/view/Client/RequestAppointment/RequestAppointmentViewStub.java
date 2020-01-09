package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

/**
 * The type Request appointment view stub.
 */
public class RequestAppointmentViewStub implements RequestAppointmentView {
    /**
     * The Message.
     */
    protected String message;

    @Override
    public void showError(String msg) {
        this.message = msg;
    }

    @Override
    public void success(String msg) {
        this.message = msg;
    }
}