package com.example.demo.Data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;


@Repository
public class CancelAttendingRepo implements CancelAttendingInterface {

    //Creating JDBC connection and giving it to class. Used to get data from database.
//    @Autowired
    private final JdbcTemplate jdbcTemplate;
    private HttpSession session;

    //Every time the repository is constructed it instantiates a JDBC connection
    public CancelAttendingRepo(JdbcTemplate aTemplate, HttpSession session) {
        jdbcTemplate = aTemplate;
        this.session = session;
    }

    /*This method searches the BookingStatus table in the database by peopleId and eventId
    and deletes that person. This method is called by methods in the CancelAttendingController.
    It allows people who are signed up to an event to cancel attending the event if they so wish*/
    @Override
    public int cancelAttending(int eventId) {
        jdbcTemplate.update("DELETE FROM BookingStatus WHERE peopleId=(?) AND eventId=(?);",
                getSessionID(), eventId
        );
        return 0;
    }

    /*This method searches the PeopleId table in the database by Email to obtain the ID
    of the person who wishes to cancel attending the event. This is then used in the function 
    above*/
    public int getSessionID() {
        return jdbcTemplate.queryForObject("select PeopleId from People where Email = ?",
                new Object[]{session.getAttribute("SESSION_USERNAME")},
                (rs, i) -> new Integer(
                        rs.getInt("PeopleId")
                )
        );
    }
}