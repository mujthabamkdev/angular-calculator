package com.timesheet.management.service;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesheet.management.model.Status;
import com.timesheet.management.repository.StatusRepository;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Status getStatusById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.orElse(null);
    }
}
