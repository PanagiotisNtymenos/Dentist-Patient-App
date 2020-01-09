package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewSchedule;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

/**
 * The type View schedule presenter.
 */
public class ViewSchedulePresenter {
    /**
     * The View.
     */
    ViewScheduleView view;

    /**
     * Instantiates a new View schedule presenter.
     *
     * @param view the view
     */
    public ViewSchedulePresenter(ViewScheduleView view) {
        this.view = view;
    }

    /**
     * This method returns a String message greeting the Dentist who asked to view his Appointment Schedule.
     *
     * @param dentistID Dentist's ID
     * @return A String message
     */
    public String onWelcome(String dentistID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        return "Welcome Dr. " + ddao.find(dentistID).getLastName() + "!\nHere you can see the appointments you have: ";
    }

    /**
     * This method returns a String message containing information regarding all of the Appointments the Dentist
     * whose ID was given as a parameter has, or a message informing that he has no Appointments if none were found.
     *
     * @param dentistID Dentist's ID
     * @return The Appointment list of the Dentist whose ID was given as a parameter or a message informing that this Dentist has no Appointments if none were found.
     */
    public String onSchedule(String dentistID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        AppointmentDAOMemory adao = new AppointmentDAOMemory();
        Dentist dentist = ddao.find(dentistID);
        String result = "";
        for (Appointment key : adao.find(dentist, AppointmentState.ACCEPTED)) {
            result += "Date: " + key.getBookDate().getDayOfMonth() + "/" + key.getBookDate().getMonth() + "/" + key.getBookDate().getYear() + " \n" + "Time: " + key.getHour() + ":" + key.getMinutes() + " \n" + "Name: " + key.getLastName() + " " + key.getFirstName() + " \n" + "Phone: " + key.getTelephoneNo() + " \n \n";
        }
        if (result != "") {
            return result;
        } else {
            return "You have no appointments :(";
        }
    }
}