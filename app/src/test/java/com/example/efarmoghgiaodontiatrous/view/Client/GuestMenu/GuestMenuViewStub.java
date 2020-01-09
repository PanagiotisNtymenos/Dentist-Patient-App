package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

/**
 * The type Guest menu view stub.
 */
public class GuestMenuViewStub implements GuestMenuView {
    private String msg, lastName, firstName, region, specialization, service;

    @Override
    public void showError(String msg) {
        this.msg = msg;
    }

    @Override
    public void showSearchView(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public void showSearchViewFilters(String region, String specialization, String service) {
        this.region = region;
        this.specialization = specialization;
        this.service = service;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Gets specialization.
     *
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Gets service.
     *
     * @return the service
     */
    public String getService() {
        return service;
    }
}