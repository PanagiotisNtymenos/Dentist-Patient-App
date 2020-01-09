package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

import java.util.List;

/**
 * The interface Appointment dao.
 */
public interface AppointmentDAO {
    /**
     * Deletes an Appointment from the AppointmentDAO.
     *
     * @param entity The Appointment entity to be deleted from the AppointmentDAO
     */
    void delete(Appointment entity);

    /**
     * Returns a List including all the Appointment objects in the AppointmentDAO.
     *
     * @return List of all the Appointment objects in the AppointmentDAO
     */
    List<Appointment> findAll();

    /**
     * Saves an Appointment in the AppointmentDAO.
     *
     * @param entity The Appointment entity to be saved in the AppointmentDAO
     */
    void save(Appointment entity);

    /**
     * Deletes all the AppointmentDAO entities.
     */
    void clear();

    /**
     * Finds and returns all the appointments of the dentist that was given as a parameter
     * with the AppointmentState given as a parameter.
     *
     * @param dentist Dentist object
     * @param state   AppointmentState (ACCEPTED or PENDING)
     * @return All the appointments that were found or null
     */
    List<Appointment> find(Dentist dentist, AppointmentState state);

    /**
     * This method returns a string table that includes all the information regarding the appointments
     * that have the AppointmentState given as a parameter for the dentist given as a parameter.
     *
     * @param tempDent Dentist to look for
     * @param state    AppointmentState (ACCEPTED or PENDING)
     * @return A table of Strings that include all the information regarding the appointments that fulfil both parameters
     */
    String[] findToString(Dentist tempDent, AppointmentState state);
}