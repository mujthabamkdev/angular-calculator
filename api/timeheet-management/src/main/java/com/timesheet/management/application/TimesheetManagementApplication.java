package com.timesheet.management.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.timesheet.management")
@SpringBootApplication
public class TimesheetManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimesheetManagementApplication.class, args);
    }
}

