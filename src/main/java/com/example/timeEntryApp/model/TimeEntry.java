package com.example.timeEntryApp.model;

import java.time.LocalDateTime;

public class TimeEntry {
    private int id;
    private int hours;
    private LocalDateTime date;
    private String status;
    private String user;
    private String project;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }
}
