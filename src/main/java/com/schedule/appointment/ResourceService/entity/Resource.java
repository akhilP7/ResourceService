package com.schedule.appointment.ResourceService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "RESOURCE")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resourceId;

    @Column(name = "RESOURCE_TYPE")
    private String resourceType;

    @Column(name = "RESOURCE_MEANING")
    private String resourceMeaning;
}
