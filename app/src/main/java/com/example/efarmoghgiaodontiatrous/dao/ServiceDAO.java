package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Service;

import java.util.List;

/**
 * The interface Service dao.
 */
public interface ServiceDAO {
    /**
     * Deletes a Service from the ServiceDAO.
     *
     * @param entity The Service entity to be deleted from the ServiceDAO
     */
    void delete(Service entity);

    /**
     * Returns a List including all the Service objects in the ServiceDAO.
     *
     * @return List of all the Service objects in the ServiceDAO
     */
    List<Service> findAll();

    /**
     * Deletes all the ServiceDAO entities.
     */
    void clear();

    /**
     * Saves a Service in the ServiceDAO.
     *
     * @param entity The Service
     */
    void save(Service entity);

    /**
     * Finds and returns a Service based on its ID.
     *
     * @param serviceId Service ID
     * @return Service entity that was found or null
     */
    Service find(String serviceId);

    /**
     * Returns the next ID that can be assigned to a Service.
     *
     * @return Service ID
     */
    String nextId();
}