package com.grofers.healthchecker.service;

import com.grofers.healthchecker.dto.HealthResponseDto;
import com.grofers.healthchecker.repository.ServiceDependencyRepository;
import com.grofers.healthchecker.repository.ServiceRepository;
import com.grofers.healthchecker.repository.ServiceUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class HealthCheckService {

    @Autowired
    private ServiceUrlRepository serviceUrlRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceDependencyRepository serviceDependencyRepository;

    public HealthResponseDto getHealth(String serviceName, String serviceEnvironment){
        try {
            Integer activeDependentServices = 0;
            Integer totalDependentServices = 0;
            Integer id = serviceRepository.findIdByServiceName(serviceName);
            List<Integer> serviceIdList = new ArrayList<>();
            serviceIdList.add(id);
            getDependencyList(id, serviceIdList);
            List<String> healthEndpoints = serviceUrlRepository.getAllHealthEndpoint(serviceIdList, serviceEnvironment);
            for (String url : healthEndpoints) {
                Integer status = getStatus(url);
                if (status == 200) {
                    activeDependentServices++;
                }
                totalDependentServices++;
            }
            return new HealthResponseDto((activeDependentServices * 100.0 / totalDependentServices));
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private void getDependencyList(Integer id, List<Integer> dependencyList){

        List<Integer> serviceDependencyList = serviceDependencyRepository.getDependency(id);
        for(Integer i : serviceDependencyList){
            dependencyList.add(i);
            getDependencyList(i,dependencyList);
        }
        return;
    }

    private Integer getStatus(String healthEndpoint){
        try{
            URL url = new URL(healthEndpoint);
            HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
            return httpConnection.getResponseCode();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
