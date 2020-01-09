package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

/**
 * The type Dentist menu view stub.
 */
public class DentistMenuViewStub implements DentistMenuView {
    private int
            manageViewProfileClicks,
            manageUpdateAccountClicks,
            manageViewClientHistoryClicks,
            manageAppointmentManagementClicks,
            manageViewStatisticsClicks,
            manageViewAppointmentScheduleClicks,
            manageRecordProvidedServicesClicks;

    private DentistMenuPresenter presenter;

    /**
     * Gets presenter.
     *
     * @return the presenter
     */
    public DentistMenuPresenter getPresenter() {
        return this.presenter;
    }

    /**
     * Sets presenter.
     *
     * @param presenter the presenter
     */
    public void setPresenter(DentistMenuPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void viewProfile() {
        manageViewProfileClicks++;
    }

    @Override
    public void updateAccount() {
        manageUpdateAccountClicks++;
    }

    @Override
    public void viewClientHistory() {
        manageViewClientHistoryClicks++;
    }

    @Override
    public void appointmentManagement() {
        manageAppointmentManagementClicks++;
    }

    @Override
    public void viewStatistics() {
        manageViewStatisticsClicks++;
    }

    @Override
    public void viewAppointmentSchedule() {
        manageViewAppointmentScheduleClicks++;
    }

    @Override
    public void recordProvidedService() {
        manageRecordProvidedServicesClicks++;
    }

    /**
     * Gets manage view profile clicks.
     *
     * @return the manage view profile clicks
     */
    public int getManageViewProfileClicks() {
        return manageViewProfileClicks;
    }

    /**
     * Gets manage update account clicks.
     *
     * @return the manage update account clicks
     */
    public int getManageUpdateAccountClicks() {
        return manageUpdateAccountClicks;
    }

    /**
     * Gets manage view client history clicks.
     *
     * @return the manage view client history clicks
     */
    public int getManageViewClientHistoryClicks() {
        return manageViewClientHistoryClicks;
    }

    /**
     * Gets manage appointment management clicks.
     *
     * @return the manage appointment management clicks
     */
    public int getManageAppointmentManagementClicks() {
        return manageAppointmentManagementClicks;
    }

    /**
     * Gets manage view statistics clicks.
     *
     * @return the manage view statistics clicks
     */
    public int getManageViewStatisticsClicks() {
        return manageViewStatisticsClicks;
    }

    /**
     * Gets manage view appointment schedule clicks.
     *
     * @return the manage view appointment schedule clicks
     */
    public int getManageViewAppointmentScheduleClicks() {
        return manageViewAppointmentScheduleClicks;
    }

    /**
     * Gets manage record provided services clicks.
     *
     * @return the manage record provided services clicks
     */
    public int getManageRecordProvidedServicesClicks() {
        return manageRecordProvidedServicesClicks;
    }
}