package com.schedule.appointment.ResourceService.service;

import com.schedule.appointment.ResourceService.model.ResourceRequest;
import com.schedule.appointment.ResourceService.model.ResourceResponse;

import java.util.List;

public interface ResourceService {

    long addResource(ResourceRequest resourceRequest);

    ResourceResponse getResourceById(long resourceId);

    List<ResourceResponse> findAll();
}
