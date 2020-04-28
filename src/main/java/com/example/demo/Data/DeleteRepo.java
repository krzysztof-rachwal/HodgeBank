package com.example.demo.Data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteRepo implements DeleteInterface{

    //Creating JDBC connection and giving it to class. Used to get data from database.
    private final JdbcTemplate jdbcTemplate;
    private int eventId;

    public DeleteRepo(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public int delete (int eventId) {
        jdbcTemplate.update("DELETE FROM BookingStatus WHERE eventId = (?);",
                eventId
                );
        jdbcTemplate.update("DELETE FROM Events WHERE EventId = (?);",
                eventId
        );
        return 0;

    }

}
