package com.example.timeEntryApp.repository;

import com.example.timeEntryApp.model.TimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TimeEntryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<TimeEntry> rowMapper = new RowMapper<TimeEntry>() {
        @Override
        public TimeEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
            TimeEntry entry = new TimeEntry();
            entry.setId(rs.getInt("idtime entry"));
            entry.setHours(rs.getInt("hours"));
            entry.setDate(rs.getTimestamp("date").toLocalDateTime());
            entry.setStatus(rs.getString("status"));
            entry.setUser(rs.getString("user"));
            entry.setProject(rs.getString("project"));
            return entry;
        }
    };

    public List<TimeEntry> findAll() {
        return jdbcTemplate.query("SELECT * FROM `time entry`", rowMapper);
    }

    public TimeEntry save(TimeEntry entry) {
        String sql = "INSERT INTO `time entry` (`idtime entry`, `hours`, `date`, `status`, `user`, `project`) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                entry.getId(),
                entry.getHours(),
                entry.getDate(),
                entry.getStatus(),
                entry.getUser(),
                entry.getProject()
        );
        return entry;
    }
}
