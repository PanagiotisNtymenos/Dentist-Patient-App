package com.example.efarmoghgiaodontiatrous.domain;

/**
 * The type Specialization.
 */
public class Specialization {
    private String specializationName, specializationID;

    /**
     * Default Constructor.
     */
    public Specialization() {
    }

    /**
     * Specialization constructor where another Specialization object is given as parameter and its fields are copied.
     *
     * @param specialization Address object whose values are getting copied to the other Address object
     */
    public Specialization(Specialization specialization) {
        this.specializationName = specialization.specializationName;
        this.specializationID = specialization.specializationID;
    }

    /**
     * Specialization constructor where all values are given as parameters.
     *
     * @param specializationName Specialization's name
     * @param specializationID   Specialization's ID
     */
    public Specialization(String specializationName, String specializationID) {
        this.specializationName = specializationName;
        this.specializationID = specializationID;
    }

    /**
     * Returns Specialization's name
     *
     * @return Specialization 's name
     */
    public String getSpecializationName() {
        return specializationName;
    }

    /**
     * Sets Specialization's name
     *
     * @param specializationName Specialization's name
     */
    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    /**
     * Returns Specialization's ID
     *
     * @return Specialization 's ID
     */
    public String getSpecializationID() {
        return specializationID;
    }

    /**
     * Sets Specialization's ID
     *
     * @param specializationID Specialization's ID
     */
    public void setSpecializationID(String specializationID) {
        this.specializationID = specializationID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        return specializationName.equals(that.specializationName);
    }

    @Override
    public int hashCode() {
        if (specializationName == null) {
            return 0;
        }
        return specializationName.hashCode();
    }
}