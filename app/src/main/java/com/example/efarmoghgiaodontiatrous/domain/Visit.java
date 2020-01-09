package com.example.efarmoghgiaodontiatrous.domain;

import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Visit.
 */
public class Visit {
    private SimpleCalendar dateOfVisit;
    private String comments;
    private Dentist dentist;
    private Client client;
    private Set<Service> services = new HashSet<>();

    /**
     * Default Constructor.
     */
    public Visit() {
    }

    /**
     * visit constructor where another visit object is given as parameter and its fields are copied.
     *
     * @param visit Visit object whose values are getting copied to the other Visit object
     */
    public Visit(Visit visit) {
        this.setDateOfVisit(visit.getDateOfVisit());
        this.setComments(visit.getComments());
        this.setDentist(visit.getDentist());
        this.setClient(visit.getClient());
        this.setServices(visit.getServices());
    }

    /**
     * Visit constructor where all values are given as parameters.
     *
     * @param dateOfVisit The date that the client visited the dentist
     * @param comments    Any comments related to the visit that the dentist added
     * @param dentist     The Dentist that was visited by the client
     * @param client      The Client that visited the dentist
     * @param services    Set of the Services that were provided to the Client
     */
    public Visit(SimpleCalendar dateOfVisit, String comments, Dentist dentist, Client client, Set<Service> services) {
        this.dateOfVisit = dateOfVisit;
        this.comments = comments;
        this.dentist = dentist;
        this.client = client;
        this.services = services;
    }

    /**
     * Returns the date that the client visited the dentist.
     *
     * @return The date that the client visited the dentist
     */
    public SimpleCalendar getDateOfVisit() {
        return dateOfVisit;
    }

    /**
     * Sets the date that the client visited the dentist.
     *
     * @param dateOfVisit The date that the client visited the dentist
     */
    public void setDateOfVisit(SimpleCalendar dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    /**
     * Returns comments related to the visit
     *
     * @return Any comments related to the visit that the dentist added
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets comments related to the visit
     *
     * @param comments Any comments related to the visit that the dentist added
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Returns the Dentist that was visited by the client.
     *
     * @return The Dentist that was visited by the client
     */
    public Dentist getDentist() {
        return dentist;
    }

    /**
     * Sets the Dentist that was visited by the client.
     *
     * @param dentist The Dentist that was visited by the client
     */
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    /**
     * Returns the Client that visited the dentist.
     *
     * @return The Client that visited the dentist
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the Client that visited the dentist.
     *
     * @param client The Client that visited the dentist
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Returns the Services that were provided to the Client.
     *
     * @return Set of the Services that were provided to the Client
     */
    public Set<Service> getServices() {
        return new HashSet<>(services);
    }

    /**
     * Sets the Services that were provided to the Client.
     *
     * @param services Set of the Services that were provided to the Client
     */
    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (!dateOfVisit.equals(visit.dateOfVisit)) return false;
        if (!comments.equals(visit.comments)) return false;
        if (!dentist.equals(visit.dentist)) return false;
        if (!client.equals(visit.client)) return false;
        return services.equals(visit.services);
    }

    @Override
    public int hashCode() {
        if (dateOfVisit == null && comments == null && dentist == null && client == null && services == null) {
            return 0;
        }
        int result = dateOfVisit.hashCode();
        result = 31 * result + comments.hashCode();
        result = 31 * result + dentist.hashCode();
        result = 31 * result + client.hashCode();
        result = 31 * result + services.hashCode();
        return result;
    }
}