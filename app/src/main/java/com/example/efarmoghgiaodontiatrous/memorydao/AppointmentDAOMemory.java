package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Appointment dao memory.
 */
public class AppointmentDAOMemory implements AppointmentDAO {
    /**
     * The constant entities.
     */
    protected static List<Appointment> entities = new ArrayList<>();

    @Override
    public void delete(Appointment entity) {
        entities.remove(entity);
    }

    @Override
    public List<Appointment> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void save(Appointment entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public List<Appointment> find(Dentist dentist, AppointmentState state) {
        List<Long> timePositions = new ArrayList<>();
        List<Appointment> dentistEntities = new ArrayList<>();
        for (Appointment appointment : entities) {
            if (appointment.getDentist() == dentist && appointment.getState() == state) {
                timePositions.add(Long.parseLong(appointment.getBookDate().getYear() + "" + appointment.getBookDate().getStringMonth() + "" + appointment.getBookDate().getStringDay() + "" + appointment.getHour() + appointment.getMinutes()));
                dentistEntities.add(appointment);
            }
        }
        if (timePositions.size() > 0) {
            Long tempInt;
            Appointment temp;
            for (int i = 0; i < timePositions.size(); i++) {
                for (int j = 1; j < timePositions.size() - i; j++) {
                    if (timePositions.get(j - 1) > timePositions.get(j)) {
                        tempInt = timePositions.get(j);
                        timePositions.set(j, timePositions.get(j - 1));
                        timePositions.set(j - 1, tempInt);
                        temp = dentistEntities.get(j);
                        dentistEntities.set(j, dentistEntities.get(j - 1));
                        dentistEntities.set(j - 1, temp);
                    }
                }
            }
        }
        return new ArrayList<>(dentistEntities);
    }

    @Override
    public void clear() {
        entities.clear();
    }

    @Override
    public String[] findToString(Dentist tempDent, AppointmentState state) {
        List<Appointment> dentistEntities = find(tempDent, state);
        String[] out = new String[dentistEntities.size()];
        for (int i = 0; i < dentistEntities.size(); i++)
            out[i] = dentistEntities.get(i).getBookDate().getDayOfMonth() + "/" + dentistEntities.get(i).getBookDate().getMonth() +
                    "/" + dentistEntities.get(i).getBookDate().getYear() + " " + dentistEntities.get(i).getHour() + ":" +
                    dentistEntities.get(i).getMinutes() + "\n" + dentistEntities.get(i).getLastName() + " " +
                    dentistEntities.get(i).getFirstName() + "\n" + dentistEntities.get(i).getTelephoneNo();
        return out;
    }
}