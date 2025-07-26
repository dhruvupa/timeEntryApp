package com.example.timeEntryApp.controller;

import com.example.timeEntryApp.model.Project;
import com.example.timeEntryApp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository repository;

    @GetMapping
    public List<Project> getAllProjects() {
        return repository.findAll();
    }
}
