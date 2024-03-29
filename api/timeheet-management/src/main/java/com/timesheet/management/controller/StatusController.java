package com.timesheet.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.management.model.Status;
import com.timesheet.management.service.StatusService;

@RestController
@RequestMapping("/statuses")
public class StatusController {
    @Autowired
    private StatusService statusService;

    // Get all statuses
    @GetMapping("/get-all-statuses")
    public List<Status> getAllStatuses() {
        return statusService.getAllStatuses();
    }
}

