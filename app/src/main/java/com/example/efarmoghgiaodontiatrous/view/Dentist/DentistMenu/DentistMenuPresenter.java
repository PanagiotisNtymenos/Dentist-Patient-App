package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

/**
 * Depending on the click of the Dentist he will be redirected in some other Activities
 */
public class DentistMenuPresenter {
    private DentistMenuView view;

    /**
     * Instantiates a new Dentist menu presenter.
     *
     * @param view the view
     */
    public DentistMenuPresenter(DentistMenuView view) {
        this.view = view;
    }

    /**
     * On view profile.
     */
    public void onViewProfile() {
        view.viewProfile();
    }

    /**
     * On update account.
     */
    public void onUpdateAccount() {
        view.updateAccount();
    }

    /**
     * On view client history.
     */
    public void onViewClientHistory() {
        view.viewClientHistory();
    }

    /**
     * On appointment management.
     */
    public void onAppointmentManagement() {
        view.appointmentManagement();
    }

    /**
     * On view statistics.
     */
    public void onViewStatistics() {
        view.viewStatistics();
    }

    /**
     * On view appointment schedule.
     */
    public void onViewAppointmentSchedule() {
        view.viewAppointmentSchedule();
    }

    /**
     * On record provided service.
     */
    public void onRecordProvidedService() {
        view.recordProvidedService();
    }
}