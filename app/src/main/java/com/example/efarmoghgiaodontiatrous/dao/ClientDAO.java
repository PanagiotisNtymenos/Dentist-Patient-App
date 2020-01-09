package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Client;

import java.util.List;

/**
 * The interface Client dao.
 */
public interface ClientDAO {
    /**
     * Deletes a Client object from the ClientDAO.
     *
     * @param entity The Client entity to be deleted from the ClientDAO
     */
    void delete(Client entity);

    /**
     * Returns a List including all the Client objects in the ClientDAO.
     *
     * @return List of all the Client objects in the ClientDAO
     */
    List<Client> findAll();

    /**
     * Deletes all the ClientDAO entities.
     */
    void clear();

    /**
     * Saves a Client in the ClientDAO.
     *
     * @param entity The Client entity to be saved in the ClientDAO
     */
    void save(Client entity);

    /**
     * Finds and returns a Client based on the AMKA number given as a parameter.
     *
     * @param clientAMKA Client's AMKA number
     * @return The client that was found or null
     */
    Client find(String clientAMKA);
}