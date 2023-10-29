package com.timesheet.management.controller;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.timesheet.management.model.Status;
import com.timesheet.management.model.Timesheet;
import com.timesheet.management.model.User;
import com.timesheet.management.service.StatusService;
import com.timesheet.management.service.TimesheetService;
import com.timesheet.management.service.UserService;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private UserService userService;
    @Autowired
    private StatusService statusService;
    
    // Get all timesheets
    @GetMapping("/get-all-timesheets")
    public List<Timesheet> getAllTimesheets() {
        return timesheetService.getAllTimesheets();
    }

    // Create a new timesheet
    @PostMapping("/create-timesheet")
    public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
        return timesheetService.createTimesheet(timesheet);
    }

    // Get timesheets by status
    @GetMapping("/by-status/{statusId}")
    public List<Timesheet> getTimesheetsByStatus(@PathVariable Long statusId) {
        Status status = statusService.getStatusById(statusId);
        return timesheetService.getTimesheetsByStatus(status);
    }

    // Get timesheets by assigned user
    @GetMapping("/by-user/{userId}")
    public List<Timesheet> getTimesheetsByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return timesheetService.getTimesheetsByAssignedUser(user);
    }

    // Get timesheets between two dates
    @GetMapping("/between-dates")
    public List<Timesheet> getTimesheetsBetweenDates(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return timesheetService.getTimesheetsBetweenDates(startDate, endDate);
    }
    
    // Delete a timesheet by ID
    @DeleteMapping("/delete-timesheet/{timesheetId}")
    public ResponseEntity<String> deleteTimesheet(@PathVariable Long timesheetId) {
        if (timesheetId != null) {
            timesheetService.deleteTimesheetById(timesheetId);
            return ResponseEntity.ok("Timesheet with ID " + timesheetId + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

