package com.grofers.healthcheck;

import java.io.Serializable;
import java.util.Objects;

public class ServiceID implements Serializable {

    private String serviceName;
    private String serviceEnvironment;

    public ServiceID(){

    }

    public ServiceID(String serviceName, String ServiceEnvironment){
        this.serviceName=serviceName;
        this.serviceEnvironment=serviceEnvironment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceID serviceID = (ServiceID) o;
        return serviceName.equals(serviceID.serviceName) &&
                serviceEnvironment.equals(serviceID.serviceEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, serviceEnvironment);
    }

}
