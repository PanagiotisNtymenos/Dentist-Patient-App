package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.List;

/**
 * The type Dentist appointment management presenter.
 */
public class DentistAppointmentManagementPresenter {

    private final DentistAppointmentManagementView view;

    /**
     * Instantiates a new Dentist appointment management presenter.
     *
     * @param view the view
     */
    DentistAppointmentManagementPresenter(DentistAppointmentManagementView view) {
        this.view = view;
    }

    /**
     * This method gets a Dentist ID and Appointment State as parameters and returns a String table that contains
     * all the Appointments this Dentist has, turning them into String messages and placing each Appointment in a single
     * table spot.
     *
     * @param dentistID Dentist's ID
     * @param state     Appointment's state
     * @return A String table containing all the Appointments and turns them to String messages using findToString
     */
    public String[] getAppointments(String dentistID, AppointmentState state) {
        AppointmentDAOMemory aDAO = new AppointmentDAOMemory();
        DentistDAOMemory dDAO = new DentistDAOMemory();
        Dentist temp = dDAO.find(dentistID);

        return aDAO.findToString(temp, state);
    }

    /**
     * Accepts the Appointments found in the selectedAppointments list given as a parameter.
     *
     * @param dentistID            Dentist's ID
     * @param selectedAppointments List of String type that contains all the selected Appointments
     */
    public void acceptAppointments(String dentistID, List<String> selectedAppointments) {
        DentistDAOMemory dDAO = new DentistDAOMemory();
        Dentist temp = dDAO.find(dentistID);
        AppointmentDAOMemory aDAO = new AppointmentDAOMemory();
        List<Appointment> allAppointments = aDAO.findAll();

        for (int i = 0; i < selectedAppointments.size(); i++) {
            String[] dateParts = selectedAppointments.get(i).split("/");
            int simpleDay = Integer.parseInt(dateParts[0]);
            int simpleMonth = Integer.parseInt(dateParts[1]);
            int simpleYear = Integer.parseInt(dateParts[2].charAt(0) + "" + dateParts[2].charAt(1) + "" + dateParts[2].charAt(2) + "" + dateParts[2].charAt(3));
            System.out.println(simpleMonth == simpleYear);
            String[] takeparts = selectedAppointments.get(i).split(" ");
            String fullTime = takeparts[1];
            String hourString = fullTime.charAt(0) + "" + fullTime.charAt(1);
            int hour = Integer.parseInt(hourString);
            String minuteString = fullTime.charAt(3) + "" + fullTime.charAt(4);
            int minutes = Integer.parseInt(minuteString);
            System.out.println(hour == minutes);
            for (int j = 0; j < allAppointments.size(); j++) {
                if (temp.equals(allAppointments.get(j).getDentist()) && allAppointments.get(j).getBookDate().equals(new SimpleCalendar(simpleYear, simpleMonth, simpleDay)) && hour == Integer.parseInt(allAppointments.get(j).getHour()) && minutes == Integer.parseInt(allAppointments.get(j).getMinutes())) {
                    allAppointments.get(j).setState(AppointmentState.ACCEPTED);
                    break;
                }
            }
        }
        view.jobDone("Appointment(s) were accepted!");
    }

    /**
     * Declines the Appointments found in the selectedAppointments list given as a parameter.
     *
     * @param dentistID            Dentist's ID
     * @param selectedAppointments List of String type that contains all the selected Appointments
     */
    public void declineAppointments(String dentistID, List<String> selectedAppointments) {
        DentistDAOMemory dDAO = new DentistDAOMemory();
        Dentist temp = dDAO.find(dentistID);
        AppointmentDAOMemory aDAO = new AppointmentDAOMemory();
        List<Appointment> allAppointments = aDAO.findAll();

        for (int i = 0; i < selectedAppointments.size(); i++) {
            String[] dateParts = selectedAppointments.get(i).split("/");
            int simpleDay = Integer.parseInt(dateParts[0]);
            int simpleMonth = Integer.parseInt(dateParts[1]);
            int simpleYear = Integer.parseInt(dateParts[2].charAt(0) + "" + dateParts[2].charAt(1) + "" + dateParts[2].charAt(2) + "" + dateParts[2].charAt(3));
            System.out.println(simpleMonth == simpleYear);
            String[] takeparts = selectedAppointments.get(i).split(" ");
            String fullTime = takeparts[1];
            String hourString = fullTime.charAt(0) + "" + fullTime.charAt(1);
            int hour = Integer.parseInt(hourString);
            String minuteString = fullTime.charAt(3) + "" + fullTime.charAt(4);
            int minutes = Integer.parseInt(minuteString);
            System.out.println(hour == minutes);
            for (int j = 0; j < allAppointments.size(); j++) {
                if (temp.equals(allAppointments.get(j).getDentist()) && allAppointments.get(j).getBookDate().equals(new SimpleCalendar(simpleYear, simpleMonth, simpleDay)) && hour == Integer.parseInt(allAppointments.get(j).getHour()) && minutes == Integer.parseInt(allAppointments.get(j).getMinutes())) {
                    aDAO.delete(allAppointments.get(j));
                    break;
                }
            }
        }
        view.jobDone("Appointment(s) were rejected!");
    }
}