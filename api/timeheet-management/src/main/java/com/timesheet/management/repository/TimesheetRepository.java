package com.timesheet.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.management.model.Status;
import com.timesheet.management.model.Timesheet;
import com.timesheet.management.model.User;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
    List<Timesheet> findAll();
    List<Timesheet> findByStatus(Status status);
    List<Timesheet> findByAssignedTo(User user);
    List<Timesheet> findByFromDateBetween(Date startDate, Date endDate);
    void deleteById(Long id);
}

