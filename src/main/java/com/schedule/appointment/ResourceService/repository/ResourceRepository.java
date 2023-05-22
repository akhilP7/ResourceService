package com.schedule.appointment.ResourceService.repository;

import com.schedule.appointment.ResourceService.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}