package com.grofers.healthcheck;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ServiceID.class)
@Table(name="service")
public class Service {
    @Id
    private String serviceName;
    @Id
    private String serviceEnvironment;
    private String healthURL;

    public Service(){}

    public Service(String serviceName, String serviceEnvironment, String healthURL){
        this.serviceName=serviceName;
        this.serviceEnvironment=serviceEnvironment;
        this.healthURL=healthURL;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceEnvironment() {
        return serviceEnvironment;
    }

    public void setServiceEnvironment(String serviceEnvironment) {
        this.serviceEnvironment = serviceEnvironment;
    }

    public String getHealthURL() {
        return healthURL;
    }

    public void setHealthURL(String healthURL) {
        this.healthURL = healthURL;
    }
}