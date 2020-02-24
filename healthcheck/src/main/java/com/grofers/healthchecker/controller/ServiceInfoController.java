package com.grofers.healthchecker.controller;

import com.grofers.healthchecker.dto.HealthResponseDto;
import com.grofers.healthchecker.service.HealthCheckService;
import com.grofers.healthchecker.service.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/healthcheckapp")
public class ServiceInfoController {

    @Autowired
    private UpdateInfoService updateInfoService;


    @PostMapping(path="/createserviceurl")
    public ResponseEntity setServiceUrl(@RequestParam String serviceName, @RequestParam String serviceEnvironment, @RequestParam String serviceURL){
        return new ResponseEntity(updateInfoService.updateServiceUrl(serviceName,serviceEnvironment,serviceURL),HttpStatus.CREATED);
    }

    @PostMapping(path="/createservice")
    public  ResponseEntity setHealthEndpoint(@RequestParam String serviceName, @RequestParam String healthCheckEndpoint){
        return new ResponseEntity(updateInfoService.updateService(serviceName,healthCheckEndpoint),HttpStatus.CREATED);
    }

    @PostMapping(path="/createdependency")
    public  ResponseEntity setDependency(@RequestParam String serviceName, @RequestParam String dependsOn){
        return new ResponseEntity(updateInfoService.updateServiceDependency(serviceName,dependsOn),HttpStatus.CREATED);
    }

}
