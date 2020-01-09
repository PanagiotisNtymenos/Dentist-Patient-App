package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.domain.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Client dao memory.
 */
public class ClientDAOMemory implements ClientDAO {
    /**
     * The constant entities.
     */
    protected static List<Client> entities = new ArrayList<>();

    @Override
    public void delete(Client entity) {
        entities.remove(entity);
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void save(Client entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public void clear() {
        entities.clear();
    }

    @Override
    public Client find(String clientAMKA) {
        for (Client client : entities) {
            if (client.getAMKA().equals(clientAMKA)) {
                return client;
            }
        }
        return null;
    }
}