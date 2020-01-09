package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Specialization;

import java.util.List;

/**
 * The interface Specialization dao.
 */
public interface SpecializationDAO {
    /**
     * Deletes a Specialization from the SpecializationDAO.
     *
     * @param entity The Specialization entity to be deleted from the SpecializationDAO
     */
    void delete(Specialization entity);

    /**
     * Deletes all the SpecializationDAO entities.
     */
    void clear();

    /**
     * Returns a List including all the Specialization objects in the SpecializationDAO.
     *
     * @return List of all the Specialization objects in the SpecializationDAO
     */
    List<Specialization> findAll();

    /**
     * Saves a Specialization in the SpecializationDAO.
     *
     * @param entity The Specialization
     */
    void save(Specialization entity);

    /**
     * Finds and returns a Specialization based on its ID.
     *
     * @param specializationId Specialization ID
     * @return Specialization entity that was found or null
     */
    Specialization find(String specializationId);

    /**
     * Returns the next ID that can be assigned to a Specialization.
     *
     * @return Specialization ID
     */
    String nextId();
}