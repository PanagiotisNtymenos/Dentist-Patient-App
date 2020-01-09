package com.example.efarmoghgiaodontiatrous.util;

/**
 * The type Address.
 */
public class Address {
    private String street, number, city, country = "Greece";
    private int zip;

    /**
     * Default Constructor.
     */
    public Address() {
    }

    /**
     * Address constructor where another Address object is given as parameter and its fields are copied.
     *
     * @param address Address object whose values are getting copied to the other Address object
     */
    public Address(Address address) {
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
        this.zip = address.getZipCode();
        this.country = address.getCountry();
    }

    /**
     * Address constructor where all values are given as parameters.
     *
     * @param street  Street name
     * @param number  Street number
     * @param city    City name
     * @param country Country name
     * @param zip     Zip code
     */
    public Address(String street, String number, String city, String country, int zip) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    /**
     * Prints a String containing all the Address fields.
     *
     * @return String that contains all the Address fields
     */
    public String print() {
        return (street + " " + number + ", " + zip + ", " + city + ", " + country);
    }

    /**
     * Returns the Address street.
     *
     * @return Address 's street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the Address street.
     *
     * @param street Address's street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns the Address street number.
     *
     * @return Address 's street number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the Address street number.
     *
     * @param number Address's street number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Returns the Address city.
     *
     * @return Address 's city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the Address city.
     *
     * @param city Address's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the Address zip code.
     *
     * @return Address 's zip code
     */
    public int getZipCode() {
        return zip;
    }

    /**
     * Sets the Address zip code.
     *
     * @param zipcode Address's zip code
     */
    public void setZipCode(int zipcode) {
        this.zip = zipcode;
    }

    /**
     * Returns the Address country.
     *
     * @return Address 's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the Address country.
     *
     * @param country Address's country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (zip != address.zip) return false;
        if (!street.equals(address.street)) return false;
        if (!number.equals(address.number)) return false;
        if (!city.equals(address.city)) return false;
        return country.equals(address.country);
    }

    @Override
    public int hashCode() {
        if (street == null && number == null && city == null && zip == 0 && country == null) {
            return 0;
        }
        int result = 0;
        result = street == null ? result : 13 * result + street.hashCode();
        result = number == null ? result : 13 * result + number.hashCode();
        result = city == null ? result : 13 * result + city.hashCode();
        result = zip == 0 ? result : 13 * result + zip;
        result = country == null ? result : 13 * result + country.hashCode();
        return result;
    }
}