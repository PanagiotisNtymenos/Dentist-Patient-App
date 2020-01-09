package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Visit;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Visit dao memory.
 */
public class VisitDAOMemory implements VisitDAO {
    /**
     * The constant entities.
     */
    protected static List<Visit> entities = new ArrayList<>();

    @Override
    public void clear() {
        entities.clear();
    }

    @Override
    public void delete(Visit entity) {
        entities.remove(entity);
    }

    @Override
    public List<Visit> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void save(Visit entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public List<Visit> find(String AMKA) {
        List<Visit> visits = new ArrayList<>();
        for (Visit visit : entities) {
            if (visit.getClient().getAMKA().equals(AMKA)) {
                visits.add(visit);
            }
        }
        return visits;
    }
}