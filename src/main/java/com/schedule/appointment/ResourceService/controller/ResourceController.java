package com.schedule.appointment.ResourceService.controller;

import com.schedule.appointment.ResourceService.model.ResourceRequest;
import com.schedule.appointment.ResourceService.model.ResourceResponse;
import com.schedule.appointment.ResourceService.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{resourceId}")
    public ResponseEntity<ResourceResponse> getResource(@PathVariable("resourceId") long resourceId){

        ResourceResponse resourceResponse = resourceService.getResourceById(resourceId);
        return new ResponseEntity<>(resourceResponse,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getResources(){

        List<ResourceResponse> resourceResponse = resourceService.findAll();
        return new ResponseEntity<>(resourceResponse,HttpStatus.OK);
    }
}
