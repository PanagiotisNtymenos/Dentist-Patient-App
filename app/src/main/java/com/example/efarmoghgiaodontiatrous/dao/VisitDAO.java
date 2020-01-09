package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Visit;

import java.util.List;

/**
 * The interface Visit dao.
 */
public interface VisitDAO {
    /**
     * Deletes a Visit from the VisitDAO.
     *
     * @param entity The Visit entity to be deleted from the VisitDAO.
     */
    void delete(Visit entity);

    /**
     * Deletes all the VisitDAO entities.
     */
    void clear();

    /**
     * Returns a List including all the Visit objects in the VisitDAO.
     *
     * @return List of all the Visit objects in the VisitDAO
     */
    List<Visit> findAll();

    /**
     * Saves a Visit in the VisitDAO.
     *
     * @param entity The Visit entity to be saved in the VisitDAO
     */
    void save(Visit entity);

    /**
     * Finds and returns a List of Visits based on the Client's AMKA number given as a parameter.
     *
     * @param AMKA Client's AMKA number
     * @return List of all the Visit entities that were found or null
     */
    List<Visit> find(String AMKA);
}