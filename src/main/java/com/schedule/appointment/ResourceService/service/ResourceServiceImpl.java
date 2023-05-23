package com.schedule.appointment.ResourceService.service;

import com.schedule.appointment.ResourceService.entity.Resource;
import com.schedule.appointment.ResourceService.exception.ResourceServiceCustomException;
import com.schedule.appointment.ResourceService.model.ResourceRequest;
import com.schedule.appointment.ResourceService.model.ResourceResponse;
import com.schedule.appointment.ResourceService.repository.ResourceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public long addResource(ResourceRequest resourceRequest) {

        log.info("Adding a new resource entry....");

        Resource resource = Resource.builder()
                .resourceType(resourceRequest.getResourceType())
                .resourceMeaning(resourceRequest.getResourceMeaning())
                .resourceAvailabilityDate(resourceRequest.getResourceAvailabilityDate())
                .resourceAvailabilityStartTime(resourceRequest.getResourceAvailabilityStartTime())
                .resourceAvailabilityEndTime(resourceRequest.getResourceAvailabilityEndTime())
        .build();

        resourceRepository.save(resource);

        log.info("Resource created");
        return resource.getResourceId();
    }

    @Override
    public ResourceResponse getResourceById(long resourceId) {

        log.info("Retrieving resource with id: {}",resourceId);

        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(
                        ()-> new ResourceServiceCustomException("Resource with given Id is not found","Resource not found")
                );

        ResourceResponse resourceResponse = new ResourceResponse();
        BeanUtils.copyProperties(resource,resourceResponse);

        return resourceResponse;
    }

    @Override
    public List<ResourceResponse> findAll() {

        List<Resource> resources = resourceRepository.findAll();
        List<ResourceResponse> resourceResponses = new ArrayList<>();

        for (Resource resource : resources) {
            ResourceResponse resourceResponse = new ResourceResponse();
            BeanUtils.copyProperties(resource, resourceResponse);
            resourceResponses.add(resourceResponse);
        }

        return resourceResponses;
    }
}
