package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.domain.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Service dao memory.
 */
public class ServiceDAOMemory implements ServiceDAO {
    /**
     * The constant entities.
     */
    protected static List<Service> entities = new ArrayList<>();

    @Override
    public void delete(Service entity) {
        entities.remove(entity);
    }

    @Override
    public List<Service> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void save(Service entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public Service find(String serviceId) {
        for (Service service : entities) {
            if (service.getServiceID().equals(serviceId)) {
                return service;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        entities.clear();
    }

    @Override
    public String nextId() {
        System.out.println(entities.size());
        if (entities.size() > 0) {
            return Integer.parseInt(entities.get(entities.size() - 1).getServiceID()) + 1 + "";
        } else {
            return 1 + "";
        }
    }
}