package com.example.efarmoghgiaodontiatrous.domain;

/**
 * The type Client.
 */
public class Client {
    private String firstName, lastName, telephoneNo, email, AMKA;

    /**
     * Default constructor
     */
    public Client() {
    }

    /**
     * Client constructor where another Client object is given as parameter and its fields are copied.
     *
     * @param client Client object whose values are getting copied to the other Client object
     */
    public Client(Client client) {
        this.setFirstName(client.getFirstName());
        this.setLastName(client.getLastName());
        this.setTelephoneNo(client.getTelephoneNo());
        this.setEmail(client.getEmail());
        this.setAMKA(client.getAMKA());
    }

    /**
     * Client constructor where all values are given as parameters.
     *
     * @param firstName   Client's first name
     * @param lastName    Client's last name
     * @param telephoneNo Client's telephone number
     * @param email       Client's email
     * @param AMKA        Client's AMKA
     */
    public Client(String firstName, String lastName, String telephoneNo, String email, String AMKA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.email = email;
        this.AMKA = AMKA;
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
     * Returns the Client's AMKA.
     *
     * @return Client 's AMKA
     */
    public String getAMKA() {
        return AMKA;
    }

    /**
     * Sets the Client's AMKA.
     *
     * @param AMKA Client's AMKA
     */
    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return AMKA.equals(client.AMKA);
    }

    @Override
    public int hashCode() {
        return AMKA.hashCode();
    }
}