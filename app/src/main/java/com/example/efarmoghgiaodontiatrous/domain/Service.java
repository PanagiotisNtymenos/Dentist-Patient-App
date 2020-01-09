package com.example.efarmoghgiaodontiatrous.domain;

/**
 * The type Service.
 */
public class Service {
    private String serviceName, serviceID;

    /**
     * Default Constructor.
     */
    public Service() {
    }

    /**
     * Service constructor where another Service object is given as parameter and its fields are copied.
     *
     * @param service Service object whose values are getting copied to the other Service object
     */
    public Service(Service service) {
        this.serviceName = service.serviceName;
        this.serviceID = service.serviceID;
    }

    /**
     * Service constructor where all values are given as parameters.
     *
     * @param serviceName Service's name
     * @param serviceID   Service's ID
     */
    public Service(String serviceName, String serviceID) {
        this.serviceName = serviceName;
        this.serviceID = serviceID;
    }

    /**
     * Returns Service's name.
     *
     * @return Service 's name
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets Service's name.
     *
     * @param serviceName Service's name
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Returns Service's ID.
     *
     * @return Service 's ID
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * Sets Service's ID.
     *
     * @param serviceID Service's ID
     */
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        return serviceName.equals(service.serviceName);
    }

    @Override
    public int hashCode() {
        if (serviceName == null) {
            return 0;
        }
        return serviceName.hashCode();
    }
}