package com.schedule.appointment.ResourceService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourceRequest {

    private String resourceType;
    private String resourceMeaning;
    private LocalDate resourceAvailabilityDate;
    private LocalTime resourceAvailabilityStartTime;
    private LocalTime resourceAvailabilityEndTime;
}
