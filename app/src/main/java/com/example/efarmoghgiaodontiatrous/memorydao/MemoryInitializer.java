package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.SpecializationDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;

/**
 * The type Memory initializer.
 */
public class MemoryInitializer extends Initializer {
    /**
     * Returns the Appointments' DAO.
     *
     * @return Appointments' DAO.
     */
    @Override
    public AppointmentDAO getAppointmentDAO() {
        return new AppointmentDAOMemory();
    }

    /**
     * Returns the Clients' DAO.
     *
     * @return Clients' DAO.
     */
    @Override
    public ClientDAO getClientDAO() {
        return new ClientDAOMemory();
    }

    /**
     * Returns the Dentists' DAO.
     *
     * @return Dentists' DAO.
     */
    @Override
    public DentistDAO getDentistDAO() {
        return new DentistDAOMemory();
    }

    /**
     * Returns the Services' DAO.
     *
     * @return Services' DAO.
     */
    @Override
    public ServiceDAO getServiceDAO() {
        return new ServiceDAOMemory();
    }

    /**
     * Returns the Specializations' DAO.
     *
     * @return Specializations' DAO.
     */
    @Override
    public SpecializationDAO getSpecializationDAO() {
        return new SpecializationDAOMemory();
    }

    /**
     * Returns the Visits' DAO.
     *
     * @return Visits' DAO.
     */
    @Override
    public VisitDAO getVisitDAO() {
        return new VisitDAOMemory();
    }

    /**
     * Erases all the data from the DAOs.
     */
    public void eraseData() {
        getAppointmentDAO().clear();
        getClientDAO().clear();
        getServiceDAO().clear();
        getSpecializationDAO().clear();
        getVisitDAO().clear();
    }
}