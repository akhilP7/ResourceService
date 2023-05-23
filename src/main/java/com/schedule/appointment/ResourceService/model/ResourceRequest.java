package com.schedule.appointment.ResourceService.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ResourceRequest {

    private String resourceType;
    private String resourceMeaning;
    private LocalDate resourceAvailabilityDate;
    private LocalTime resourceAvailabilityStartTime;
    private LocalTime resourceAvailabilityEndTime;
}
