package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class CreateEventRepo implements CreateEventInterface{
//  filled by Owen on 20/11/2019
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CreateEventRepo(JdbcTemplate CreateEventTemplate) {
        jdbcTemplate = CreateEventTemplate;
    }


    @Override
    public int addEvent(Event event) {
        return jdbcTemplate.update("insert into Events(Name,Organiser,Location,Description,TeamBased,DietReq,Date,Time) values(?,?,?,?,?,?,?,?)",
                event.getEventName(),
                event.getOrganiser(),
                event.getLocation(),
                event.getDescription(),
                event.getTeamBased(),
                event.getDReq(),
                event.getDate(),
                event.getTime());
    }

}
