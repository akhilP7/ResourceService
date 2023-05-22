package com.schedule.appointment.ResourceService.controller;

import com.schedule.appointment.ResourceService.model.ResourceRequest;
import com.schedule.appointment.ResourceService.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<Long> addResource(@RequestBody ResourceRequest resourceRequest){

        long resourceId = resourceService.addResource(resourceRequest);
        return new ResponseEntity<>(resourceId, HttpStatus.CREATED);
    }
}
