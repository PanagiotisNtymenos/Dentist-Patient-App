package com.example.efarmoghgiaodontiatrous.domain;

import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.Calendar;

/**
 * The type Appointment.
 */
public class Appointment {
    private String firstName, lastName, telephoneNo, email;
    private AppointmentState state;
    private Dentist dentist;
    private SimpleCalendar bookDate;
    private int hour, minutes;

    /**
     * Default Constructor.
     */
    public Appointment() {
        new Dentist();
        new SimpleCalendar(Calendar.getInstance());
        this.setState(AppointmentState.PENDING);
    }

    /**
     * Appointment constructor where another Appointment object is given as parameter and its fields are copied.
     *
     * @param appointment Appointment object whose values are getting copied to the other Appointment object
     */
    public Appointment(Appointment appointment) {
        this.setFirstName(appointment.getFirstName());
        this.setLastName(appointment.getLastName());
        this.setTelephoneNo(appointment.getTelephoneNo());
        this.setEmail(appointment.getEmail());
        this.setDentist(appointment.getDentist());
        this.setBookDate(appointment.getBookDate());
        this.setHour(Integer.parseInt(appointment.getHour()));
        this.setMinutes(Integer.parseInt(appointment.getMinutes()));
        this.setState(AppointmentState.PENDING);
    }

    /**
     * Appointment constructor where all values are given as parameters.
     * All the client fields below that include personal data refer to the person who requested the
     * appointment and not necessarily the one who'll be visiting the Dentist.
     *
     * @param firstName   Client's first name
     * @param lastName    Client's last name
     * @param telephoneNo Client's telephone number
     * @param dentist     The dentist that the patient will visit
     * @param bookDate    The date that the visit will be taking place
     * @param hour        the hour
     * @param minutes     the minutes
     */
    public Appointment(String firstName, String lastName, String telephoneNo, Dentist dentist, SimpleCalendar bookDate, int hour, int minutes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.dentist = dentist;
        this.bookDate = bookDate;
        this.hour = hour;
        this.minutes = minutes;
        this.setState(AppointmentState.PENDING);
    }

    /**
     * Returns the Client's first name.
     *
     * @return Client 's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the Client's first name.
     *
     * @param firstName Client's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the Client's last name.
     *
     * @return Client 's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the Client's last name.
     *
     * @param lastName Client's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the Client's telephone number.
     *
     * @return Client 's telephone number
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * Sets the Client's telephone number.
     *
     * @param telephoneNo Client's telephone number
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * Returns the Client's email.
     *
     * @return Client 's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the Client's email.
     *
     * @param email Client's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the Appointment's dentist.
     *
     * @return The dentist that the patient will visit
     */
    public Dentist getDentist() {
        return dentist;
    }

    /**
     * Sets the Appointment's dentist.
     *
     * @param dentist The dentist that the patient will visit
     */
    public void setDentist(Dentist dentist) {
        this.dentist = new Dentist(dentist);
    }

    /**
     * Returns the date that the visit will be taking place.
     *
     * @return The date that the visit will be taking place
     */
    public SimpleCalendar getBookDate() {
        return bookDate;
    }

    /**
     * Sets the date that the visit will be taking place.
     *
     * @param bookDate The date that the visit will be taking place
     */
    public void setBookDate(SimpleCalendar bookDate) {
        this.bookDate = bookDate;
    }

    /**
     * Returns the Appointment's state.
     *
     * @return Appointment 's state
     */
    public AppointmentState getState() {
        return state;
    }

    /**
     * Sets the Appointment's state.
     *
     * @param state Appointment's state
     */
    public void setState(AppointmentState state) {
        this.state = state;
    }

    /**
     * Returns the Appointment's hour value.
     *
     * @return The appointment's hour value
     */
    public String getHour() {
        if (hour == 9)
            return "09";
        return hour + "";
    }

    /**
     * Sets the Appointment's hour value.
     *
     * @param hour The hour value of the appointment
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Returns the Appointment's minute value.
     *
     * @return The appointment's minute value
     */
    public String getMinutes() {
        if (minutes == 0) {
            return "00";
        }
        return minutes + "";
    }

    /**
     * Sets the Appointment's minute value.
     *
     * @param minutes The minutes value of the appointment
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (hour != that.hour) return false;
        if (minutes != that.minutes) return false;
        if (!dentist.equals(that.dentist)) return false;
        return bookDate.equals(that.bookDate);
    }

    @Override
    public int hashCode() {
        int result = dentist.hashCode();
        result = 31 * result + bookDate.hashCode();
        result = 31 * result + hour;
        result = 31 * result + minutes;
        return result;
    }
}