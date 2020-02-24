package com.grofers.healthchecker.controller;

import com.grofers.healthchecker.dto.HealthResponseDto;
import com.grofers.healthchecker.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/healthcheckapp")
public class HealthController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping(path="/gethealth")
    public  ResponseEntity getHealth(@RequestParam(value="serviceName", defaultValue = "obelix") String serviceName, @RequestParam(value="serviceEnvironment", defaultValue = "prod") String serviceEnvironment){
        return new ResponseEntity(healthCheckService.getHealth(serviceName, serviceEnvironment), HttpStatus.OK);
    }

}
