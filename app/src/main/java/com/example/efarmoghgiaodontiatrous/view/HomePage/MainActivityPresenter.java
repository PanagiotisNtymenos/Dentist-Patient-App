package com.example.efarmoghgiaodontiatrous.view.HomePage;

/**
 * The type Main activity presenter.
 */
public class MainActivityPresenter {
    private MainActivityView view;

    /**
     * Instantiates a new Main activity presenter.
     *
     * @param view the view
     */
    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    /**
     * Sets the view on Guest Menu.
     */
    public void onGuestMenu() {
        view.guestMenu();
    }

    /**
     * Sets the view on Dentist Menu.
     */
    public void onDentistMenu() {
        view.dentistMenu();
    }
}