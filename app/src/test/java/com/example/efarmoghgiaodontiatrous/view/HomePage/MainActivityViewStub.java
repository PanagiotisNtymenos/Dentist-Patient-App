package com.example.efarmoghgiaodontiatrous.view.HomePage;

/**
 * The type Main activity view stub.
 */
public class MainActivityViewStub implements MainActivityView {
    private int guestMenuClicks, dentistMenuClicks;
    private MainActivityPresenter presenter;

    /**
     * Instantiates a new Main activity view stub.
     */
    public MainActivityViewStub() {
    }

    /**
     * Gets presenter.
     *
     * @return the presenter
     */
    public MainActivityPresenter getPresenter() {
        return presenter;
    }

    /**
     * Sets presenter.
     *
     * @param presenter the presenter
     */
    public void setPresenter(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void guestMenu() {
        guestMenuClicks++;
    }

    @Override
    public void dentistMenu() {
        dentistMenuClicks++;
    }

    /**
     * Gets guest menu clicks.
     *
     * @return the guest menu clicks
     */
    public int getGuestMenuClicks() {
        return guestMenuClicks;
    }

    /**
     * Gets dentist menu clicks.
     *
     * @return the dentist menu clicks
     */
    public int getDentistMenuClicks() {
        return dentistMenuClicks;
    }
}