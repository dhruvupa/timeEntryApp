package com.example.timeEntryApp.repository;

import com.example.timeEntryApp.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Project> findAll() {
        String sql = "SELECT `project name`, `status` FROM `project`";
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            Project project = new Project();
            project.setProjectName(rs.getString("project name"));
            project.setStatus(rs.getString("status"));
            return project;
        });
    }
}
