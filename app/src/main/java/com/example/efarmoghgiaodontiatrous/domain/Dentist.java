package com.example.efarmoghgiaodontiatrous.domain;

import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.ConnectionState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Dentist.
 */
public class Dentist {
    private static int ID = 0;
    private String firstName, lastName, telephoneNo, email, exerciseLicense, universityAttended, password, dentistID;
    private int timeOfExperience;
    private Address infirmaryLocation;
    private ConnectionState state;
    private Set<Specialization> specializations = new HashSet<>();
    private Set<Service> services = new HashSet<>();
    private Set<Appointment> appointments = new HashSet<>();

    /**
     * Default Constructor.
     */
    public Dentist() {
        this.dentistID = ID + "";
        ID++;
        this.setState(ConnectionState.DISCONNECTED);
    }

    /**
     * Dentist constructor where another Dentist object is given as parameter and its fields are copied.
     *
     * @param dentist Dentist object whose values are getting copied to the other Dentist object
     */
    public Dentist(Dentist dentist) {
        this.firstName = dentist.getFirstName();
        this.lastName = dentist.getLastName();
        this.telephoneNo = dentist.getTelephoneNo();
        this.email = dentist.getEmail();
        this.exerciseLicense = dentist.getExerciseLicense();
        this.universityAttended = dentist.getUniversityAttended();
        this.infirmaryLocation = dentist.getInfirmaryLocation();
        this.timeOfExperience = dentist.getTimeOfExperience();
        this.password = dentist.getPassword();
        this.dentistID = dentist.getID();
        this.state = dentist.getState();
    }

    /**
     * Dentist constructor where all values are given as parameters.
     *
     * @param firstName          Dentist's first name
     * @param lastName           Dentist's last name
     * @param telephoneNo        Dentist's telephone number
     * @param email              Dentist's email
     * @param exerciseLicense    Dentist's exercise license
     * @param universityAttended The university the Dentist attended
     * @param infirmaryLocation  The location of the Dentist's infirmary
     * @param timeOfExperience   Dentist's time of experience
     * @param password           Dentist's password
     */
    public Dentist(String firstName, String lastName, String telephoneNo, String email, String exerciseLicense, String universityAttended, Address infirmaryLocation, int timeOfExperience, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.email = email;
        this.exerciseLicense = exerciseLicense;
        this.universityAttended = universityAttended;
        this.infirmaryLocation = infirmaryLocation;
        this.timeOfExperience = timeOfExperience;
        this.password = password;
        this.dentistID = ID + "";
        ID++;
        this.setState(ConnectionState.DISCONNECTED);
    }

    /**
     * Returns the Dentist's first name.
     *
     * @return Dentist 's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the Dentist's first name.
     *
     * @param firstName Dentist's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the Dentist's last name.
     *
     * @return Dentist 's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Dentist's last name.
     *
     * @param lastName Dentist's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the Dentist's telephone number.
     *
     * @return Dentist 's telephone number
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * Sets the Dentist's telephone number.
     *
     * @param telephoneNo Dentist's telephone number
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * Returns the Dentist's email.
     *
     * @return Dentist 's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the Dentist's email.
     *
     * @param email Dentist's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the Dentist's exercise license.
     *
     * @return Dentist 's exercise license
     */
    public String getExerciseLicense() {
        return exerciseLicense;
    }

    /**
     * Sets the Dentist's exercise license.
     *
     * @param exerciseLicense Dentist's exercise license
     */
    public void setExerciseLicense(String exerciseLicense) {
        this.exerciseLicense = exerciseLicense;
    }

    /**
     * Returns the university the Dentist attended.
     *
     * @return The university the Dentist attended
     */
    public String getUniversityAttended() {
        return universityAttended;
    }

    /**
     * Sets the university the Dentist attended.
     *
     * @param universityAttended The university the Dentist attended
     */
    public void setUniversityAttended(String universityAttended) {
        this.universityAttended = universityAttended;
    }

    /**
     * Returns the location of the Dentist's infirmary.
     *
     * @return The location of the Dentist's infirmary
     */
    public Address getInfirmaryLocation() {
        return infirmaryLocation;
    }

    /**
     * Sets the location of the Dentist's infirmary.
     *
     * @param infirmaryLocation The location of the Dentist's infirmary
     */
    public void setInfirmaryLocation(Address infirmaryLocation) {
        this.infirmaryLocation = infirmaryLocation;
    }

    /**
     * Returns Dentist's time of experience.
     *
     * @return Dentist 's time of experience
     */
    public int getTimeOfExperience() {
        return timeOfExperience;
    }

    /**
     * Sets Dentist's time of experience.
     *
     * @param timeOfExperience Dentist's time of experience
     */
    public void setTimeOfExperience(int timeOfExperience) {
        this.timeOfExperience = timeOfExperience;
    }

    /**
     * Returns Dentist's password.
     *
     * @return Dentist 's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets Dentist's password.
     *
     * @param password Dentist's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns Dentist's ID.
     *
     * @return Dentist 's ID
     */
    public String getID() {
        return dentistID;
    }

    /**
     * Sets Dentist's ID.
     *
     * @param dentistID Dentist's ID
     */
    public void setID(String dentistID) {
        this.dentistID = dentistID;
    }

    /**
     * Returns Dentist's connection state.
     *
     * @return Dentist 's connection state
     */
    public ConnectionState getState() {
        return state;
    }

    /**
     * Sets Dentist's connection state.
     *
     * @param state Dentist's connection state
     */
    public void setState(ConnectionState state) {
        this.state = state;
    }

    /**
     * This method returns the Set of Specializations.
     *
     * @return The Set of Specializations
     */
    public Set<Specialization> getSpecializations() {
        return new HashSet<>(specializations);
    }

    /**
     * This method returns the Set of Services.
     *
     * @return The Set of Services
     */
    public Set<Service> getServices() {
        return new HashSet<>(services);
    }

    /**
     * This method returns the Set of Appointments.
     *
     * @return The Set of Appointments
     */
    public Set<Appointment> getAppointments() {
        return new HashSet<>(appointments);
    }

    /**
     * This method is called when the Dentist wants to add a Service to his/her list of services.
     *
     * @param service The Service to be added to the dentist's list of services
     */
    public void addService(Service service) {
        if (service != null) {
            this.services.add(service);
        }
    }

    /**
     * This method is called when the Dentist wants to remove a Service from his/her list of services.
     *
     * @param service The Service to be removed from the dentist's list of services
     */
    public void removeService(Service service) {
        if (service != null) {
            this.services.remove(service);
        }
    }

    /**
     * This method is called when the Dentist wants to add a Specialization to his/her list of specializations.
     *
     * @param specialization The Specialization to be added to the dentist's list of specializations
     */
    public void addSpecialization(Specialization specialization) {
        if (specialization != null) {
            this.specializations.add(specialization);
        }
    }

    /**
     * This method is called when the Dentist wants to remove a Specialization from his/her list of specializations.
     *
     * @param specialization The Specialization to be removed from the dentist's list of specializations
     */
    public void removeSpecialization(Specialization specialization) {
        if (specialization != null) {
            this.specializations.remove(specialization);
        }
    }

    /**
     * This method is called when the Dentist wants to accept an Appointment application made by a Client.
     *
     * @param appointment The Appointment that is accepted by the Dentist.
     */
    public void acceptAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
        if (appointment != null) {
            if (!appointment.getState().equals(AppointmentState.ACCEPTED))
                appointment.setState(AppointmentState.ACCEPTED);
            this.appointments.add(appointment);
        }
    }

    /**
     * This method is called when the Dentist wants to decline an Appointment application made by a Client.
     *
     * @param appointment The Appointment that is not accepted by the Dentist.
     */
    public void declineAppointment(Appointment appointment) {
        if (appointment != null) {
            this.appointments.remove(appointment);
        }
    }

    /**
     * This method is called when the Dentist wants to log in the system and unlock more of its functionality.
     * Dentist's connection state changes from DISCONNECTED to CONNECTED if the email & password that were given
     * as parameters are the same as the ones the Dentist has, according to the system.
     *
     * @param email    The email given as parameter, used for test purposes
     * @param password The password given as parameter, used for test purposes
     * @return the boolean
     */
    public boolean login(String email, String password) {
        if (this.getEmail().equals(email) && this.getPassword().equals(password)) {
            this.setState(ConnectionState.CONNECTED);
            return true;
        }
        return false;
    }

    /**
     * This method is called when the Dentist wants to record a Client's visit.
     *
     * @param dateOfVisit The date the visit took place
     * @param comments    Any comments the dentist added
     * @param dentist     The Dentist that provided services during this appointment
     * @param client      The Client that visited the dentist
     * @param service     The service that was provided by the dentist
     * @return The visit object
     */
    public Visit recordVisit(SimpleCalendar dateOfVisit, String comments, Dentist dentist, Client client, Service service) {
        Visit visit = null;
        if (dentist.services.contains(service)) {
            if (dateOfVisit == null || (!dentist.equals(this)) || client == null)
                return null;
            visit = new Visit(dateOfVisit, comments, dentist, client, services);
        }
        return visit;
    }

    /**
     * This method is called by the Dentist whenever he/she wants to create
     * a new card for a patient he/she provided service to.
     *
     * @param AMKA The new Client object's AMKA.
     * @return The client object
     */
    public Client createClientCard(String AMKA) {
        if (AMKA == null)
            return null;
        Client client = new Client();
        client.setAMKA(AMKA);
        return client;
    }

    /**
     * This method returns a String that contains all of the Dentist's Specializations separated by commas.
     *
     * @return String containing all the Specializations of a particular Dentist
     */
    public String printSpecializations() {
        String out = "";
        for (Specialization sp : specializations) {
            out += sp.getSpecializationName() + ", ";
        }
        out = out.substring(0, out.length() - 2);
        return out;
    }

    /**
     * This method returns a String that contains all of the Dentist's provided Services separated by commas.
     *
     * @return String containing all the Services of a particular Dentist
     */
    public String printServices() {
        String out = "";
        for (Service sp : services) {
            out += sp.getServiceName() + ", ";
        }
        out = out.substring(0, out.length() - 2);
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dentist dentist = (Dentist) o;

        if (!email.equals(dentist.email)) return false;
        return password.equals(dentist.password);
    }

    @Override
    public int hashCode() {
        if (this.email == null && this.password == null) {
            return 0;
        }
        int result = email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}