package com.schedule.appointment.ResourceService.service;

import com.schedule.appointment.ResourceService.entity.Resource;
import com.schedule.appointment.ResourceService.model.ResourceRequest;
import com.schedule.appointment.ResourceService.repository.ResourceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        .build();

        resourceRepository.save(resource);

        log.info("Resource created");
        return resource.getResourceId();
    }
}
