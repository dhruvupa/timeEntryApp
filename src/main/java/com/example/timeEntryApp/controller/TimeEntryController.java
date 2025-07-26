package com.example.timeEntryApp.controller;


import com.example.timeEntryApp.model.TimeEntry;
import com.example.timeEntryApp.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-entries")
@CrossOrigin(origins = "*")
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository repository;

    @GetMapping
    public List<TimeEntry> getAllEntries() {
        return repository.findAll();
    }

    @PostMapping
    public TimeEntry saveEntry(@RequestBody TimeEntry entry) {
        return repository.save(entry);
    }
}
