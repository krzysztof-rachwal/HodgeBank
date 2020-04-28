package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;


@Repository
public class SignUpRepo implements SignUpInterface {

    //Creating JDBC connection and giving it to class. Used to get data from database.
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private HttpSession session;


    public SignUpRepo (JdbcTemplate aTemplate,HttpSession session) {
        jdbcTemplate = aTemplate;
        this.session=session;
    }

    @Override
    public int signUp (BookingStatus bookingStatus) {

        int peopleID = jdbcTemplate.queryForObject("select PeopleId from People where Email = ?",
                new Object[]{session.getAttribute("SESSION_USERNAME")},
                (rs,i) -> new Integer(
                        rs.getInt("PeopleId")
                )
        );

        return jdbcTemplate.update("insert into BookingStatus(peopleId, eventId, statusId, dietReq, teamMembers)  values(?,?,?,?,?)",
                peopleID, bookingStatus.getEventId(), bookingStatus.getStatusId(), bookingStatus.getDietReq(), bookingStatus.getTeamMembers());

    }
}
