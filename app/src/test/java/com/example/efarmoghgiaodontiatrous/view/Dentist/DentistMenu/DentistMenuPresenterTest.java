package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Dentist menu presenter test.
 */
public class DentistMenuPresenterTest {
    private DentistMenuPresenter presenter;
    private DentistMenuViewStub view;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        view = new DentistMenuViewStub();
        presenter = new DentistMenuPresenter(view);
        view.setPresenter(presenter);
    }

    /**
     * This method tests the onViewProfile() method.
     */
    @Test
    public void testViewProfile() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewProfile();
        }
        Assert.assertEquals(10, view.getManageViewProfileClicks());
    }

    /**
     * This method tests the onUpdateAccount() method.
     */
    @Test
    public void testUpdateAccount() {
        for (int i = 0; i < 10; i++) {
            presenter.onUpdateAccount();
        }
        Assert.assertEquals(10, view.getManageUpdateAccountClicks());
    }

    /**
     * This method tests the onViewClientHistory() method.
     */
    @Test
    public void testViewClientHistory() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewClientHistory();
        }
        Assert.assertEquals(10, view.getManageViewClientHistoryClicks());
    }

    /**
     * This method test the onAppointmentManagement() method.
     */
    @Test
    public void testAppointmentManagement() {
        for (int i = 0; i < 10; i++) {
            presenter.onAppointmentManagement();
        }
        Assert.assertEquals(10, view.getManageAppointmentManagementClicks());
    }

    /**
     * This method tests the onViewStatistics() method.
     */
    @Test
    public void testViewStatistics() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewStatistics();
        }
        Assert.assertEquals(10, view.getManageViewStatisticsClicks());
    }

    /**
     * This method tests the onViewAppointmentSchedule() method.
     */
    @Test
    public void testViewAppointmentSchedule() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewAppointmentSchedule();
        }
        Assert.assertEquals(10, view.getManageViewAppointmentScheduleClicks());
    }

    /**
     * This method tests the onRecordProvidedService() method.
     */
    @Test
    public void testRecordProvidedServices() {
        for (int i = 0; i < 10; i++) {
            presenter.onRecordProvidedService();
        }
        Assert.assertEquals(10, view.getManageRecordProvidedServicesClicks());
    }
}