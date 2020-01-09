package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.List;

/**
 * The interface Dentist dao.
 */
public interface DentistDAO {
    /**
     * Finds and returns a list of Dentists with the first name and last name given as parameters.
     *
     * @param lastName  Dentist's last name
     * @param firstName Dentist's first name
     * @return A list of dentists that were found based on the search by name
     */
    List<Dentist> findByName(String lastName, String firstName);

    /**
     * Finds and returns a Dentist based on his ID.
     *
     * @param dentistId Dentist's ID
     * @return Dentist object that was found or null
     */
    Dentist find(String dentistId);

    /**
     * Returns the Dentist that owns the email given as a parameter.
     *
     * @param email The dentist's email.
     * @return The dentist object that owns the email given as a parameter
     */
    Dentist findByEmail(String email);

    /**
     * Saves a Dentist in the DentistDAO.
     *
     * @param entity The Dentist entity to be saved in the DentistDAO
     */
    void save(Dentist entity);

    /**
     * Deletes a Dentist from the DentistDAO.
     *
     * @param entity The Dentist entity to be deleted from the AppointmentDAO
     */
    void delete(Dentist entity);

    /**
     * Returns a List including all the Dentist objects in the DentistDAO.
     *
     * @return List of all the Dentist objects in the DentistDAO
     */
    List<Dentist> findAll();

    /**
     * Returns all the Dentist objects that meet the criteria below.
     *
     * @param region         The region of the infirmary
     * @param specialization The dentist's specialization(s)
     * @param service        The dentist's provided service(s)
     * @return Returns the dentist(s) who meet the criteria given as parameters
     */
    List<Dentist> findWithFilters(String region, String specialization, String service);
}