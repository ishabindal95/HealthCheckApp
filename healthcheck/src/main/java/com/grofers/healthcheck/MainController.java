package com.grofers.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path="/healthcheckapp")
public class MainController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping(path="/gethealthcheckurl")
    public @ResponseBody String getHealthCheckURL(@RequestParam(value="serviceName", defaultValue = "obelix") String serviceName, @RequestParam(value="serviceEnvironment", defaultValue = "prod") String serviceEnvironment){
        Service service=serviceRepository.findServiceHealthCheckURL(serviceName,serviceEnvironment);
        return service.getHealthURL();
    }

    @PostMapping(path="/sethealthcheckurl")
    public @ResponseBody String setHealthCheckURL(@RequestParam String serviceName, @RequestParam String serviceEnvironment, @RequestParam String healthURL){
        Service service = new Service();
        service.setServiceName(serviceName);
        service.setServiceEnvironment(serviceEnvironment);
        service.setHealthURL(healthURL);
        serviceRepository.save(service);
        return "Success";
    }

    @GetMapping(path="/getservicelist")
    public @ResponseBody Iterable<Service> getServiceList(){
        return serviceRepository.findAll();
    }

    @GetMapping(path="/gethealthcheck")
    public @ResponseBody String getHealthCheck(@RequestParam(value="serviceName", defaultValue = "obelix") String serviceName, @RequestParam(value="serviceEnvironment", defaultValue = "prod") String serviceEnvironment){
        String healthurl=serviceRepository.findServiceHealthCheckURL(serviceName,serviceEnvironment).getHealthURL();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(healthurl, String.class);
    }

}
