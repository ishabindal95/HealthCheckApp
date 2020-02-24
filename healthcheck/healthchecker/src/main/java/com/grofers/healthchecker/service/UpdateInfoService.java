package com.grofers.healthchecker.service;

import com.grofers.healthchecker.model.Service;
import com.grofers.healthchecker.model.ServiceDependency;
import com.grofers.healthchecker.model.ServiceUrl;
import com.grofers.healthchecker.repository.ServiceDependencyRepository;
import com.grofers.healthchecker.repository.ServiceRepository;
import com.grofers.healthchecker.repository.ServiceUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Service
public class UpdateInfoService {

    @Autowired
    ServiceUrlRepository serviceUrlRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ServiceDependencyRepository serviceDependencyRepository;

    public String updateServiceUrl(String name, String environment, String url){
        try {
            Service service = serviceRepository.findByServiceName(name);
            ServiceUrl serviceUrl = new ServiceUrl();
            serviceUrl.setEnvironment(environment);
            serviceUrl.setUrl(url);
            serviceUrl.setService(service);
            serviceUrlRepository.save(serviceUrl);
            return "Successfully created entry in Service URL.";
        }
        catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }

    public String updateService(String name, String healthEndpoint){
        try{
            Service service = new Service();
            service.setServiceName(name);
            service.setHealthEndpoint(healthEndpoint);
            serviceRepository.save(service);
            return "Successfully created entry in Service";
        }
        catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }

    public String updateServiceDependency(String name, String dependencyName){
        try{
            Service service1 = serviceRepository.findByServiceName(name);
            Service service2 = serviceRepository.findByServiceName(dependencyName);
            ServiceDependency serviceDependency = new ServiceDependency();
            serviceDependency.setService(service1);
            serviceDependency.setDependency_service(service2);
            serviceDependencyRepository.save(serviceDependency);
            return "Successfully created entry in Service Dependency";
        }
        catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
    }

}
