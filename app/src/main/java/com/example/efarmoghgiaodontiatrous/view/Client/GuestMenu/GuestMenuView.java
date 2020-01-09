package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

/**
 * The interface Guest menu view.
 */
public interface GuestMenuView {

    /**
     * Prints the String given as parameter.
     *
     * @param msg Message to be printed
     */
    void showError(String msg);

    /**
     * Gives last name & first name as extras to the new intent.
     *
     * @param lastName  Dentist's last name
     * @param firstName Dentist's first name
     */
    void showSearchView(String lastName, String firstName);

    /**
     * Gives region, specialization & service as extras to the new intent.
     *
     * @param region         Dentist Infirmary's city location
     * @param specialization Dentist's Specialization
     * @param service        Dentist's Service
     */
    void showSearchViewFilters(String region, String specialization, String service);
}
