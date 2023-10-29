package com.timesheet.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.management.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findAll();
}



