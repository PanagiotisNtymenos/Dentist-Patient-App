package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Dentist dao memory.
 */
public class DentistDAOMemory implements DentistDAO {

    /**
     * The constant entities.
     */
    protected static List<Dentist> entities = new ArrayList<>();

    @Override
    public Dentist find(String dentistId) {
        for (Dentist dentist : entities) {
            if (dentist.getID().equals(dentistId)) {
                return dentist;
            }
        }
        return null;
    }

    @Override
    public Dentist findByEmail(String email) {
        for (Dentist dentist : entities) {
            if (dentist.getEmail().equals(email)) return dentist;
        }
        return null;
    }

    @Override
    public void save(Dentist entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public void delete(Dentist entity) {
        entities.remove(entity);
    }

    @Override
    public List<Dentist> findByName(String lastName, String firstName) {
        List<Dentist> output = new ArrayList<>();
        if (lastName == null || lastName.equals("")) {
            return null;
        } else if (firstName == null || firstName.equals("")) {
            for (Dentist dentist : entities) {
                if (dentist.getLastName().equalsIgnoreCase(lastName)) {
                    output.add(dentist);
                }
            }
        } else {
            for (Dentist dentist : entities) {
                if (dentist.getLastName().equalsIgnoreCase(lastName)) {
                    if (dentist.getFirstName().equals(firstName)) {
                        output.add(dentist);
                    }
                }
            }
        }
        return new ArrayList<>(output);
    }

    @Override
    public List<Dentist> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public List<Dentist> findWithFilters(String region, String specialization, String service) {
        List<Dentist> output = new ArrayList<>();
        if ((region == null || region.equals("")) && (specialization == null || specialization.equals("") && (service == null || service.equals("")))) {
            return null;
        }

        List<Dentist> dentSpec = new ArrayList<>();
        List<Dentist> dentServ = new ArrayList<>();
        List<Dentist> dentRegion = new ArrayList<>();
        List<Dentist> dentRegionServ = new ArrayList<>();

        for (Dentist dentist : entities) {
            for (Specialization sp : dentist.getSpecializations()) {
                if (sp.getSpecializationName().equals(specialization)) {
                    dentSpec.add(dentist);
                }
            }
        }
        for (Dentist dentist : entities) {
            for (Service sp : dentist.getServices()) {
                if (sp.getServiceName().equals(service)) {
                    dentServ.add(dentist);
                }
            }
        }
        for (Dentist dentist : entities) {
            if (dentist.getInfirmaryLocation().getCity().equals(region)) {
                dentRegion.add(dentist);
            }
        }
        if (region.equals("")) {
            if (specialization.equals("")) {
                return new ArrayList<>(dentServ);
            } else if (service.equals("")) {
                return new ArrayList<>(dentSpec);
            } else {
                for (int i = 0; i < dentServ.size(); i++) {
                    if (dentSpec.contains(dentServ.get(i))) {
                        output.add(dentServ.get(i));
                    }
                }
                return new ArrayList<>(output);
            }
        }
        if (specialization.equals("")) {
            if (service.equals("")) {
                return new ArrayList<>(dentRegion);
            } else {
                for (int i = 0; i < dentServ.size(); i++) {
                    if (dentRegion.contains(dentServ.get(i))) {
                        output.add(dentServ.get(i));
                    }
                }
                return new ArrayList<>(output);
            }
        }
        if (service.equals("")) {
            for (int i = 0; i < dentSpec.size(); i++) {
                if (dentRegion.contains(dentSpec.get(i))) {
                    output.add(dentSpec.get(i));
                }
            }
            return new ArrayList<>(output);
        }
        for (int i = 0; i < dentServ.size(); i++) {
            if (dentRegion.contains(dentServ.get(i))) {
                dentRegionServ.add(dentServ.get(i));
            }
        }
        for (int i = 0; i < dentSpec.size(); i++) {
            if (dentRegionServ.contains(dentSpec.get(i))) {
                output.add(dentSpec.get(i));
            }
        }
        return new ArrayList<>(output);
    }
}