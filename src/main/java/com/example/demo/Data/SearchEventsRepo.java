package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Repository
public class SearchEventsRepo{

    //Creating JDBC connection and giving it to class. Used to get data from database.
    @Autowired
    private JdbcTemplate jdbcTemplate;
    HttpSession session;
    //System.out.println(session.getAttribute("SESSION_USERNAME"));
    private int me = 4;

    public SearchEventsRepo(JdbcTemplate aTemplate, HttpSession session){
        jdbcTemplate = aTemplate;
        this.session = session;
    }

    public List<Events> findByEvent(int val) {


        if (val==1) {
            return jdbcTemplate.query("select Name,FirstName,SurName,Location,e.Date,e.Time,e.EventId " +
                            "from Events e inner join People p on p.PeopleId = e.Organiser WHERE DATE > NOW() ORDER BY DATE",
                    new Object[]{},
                    (rs, i) -> new Events(
                            rs.getString("Name"),
                            rs.getString("FirstName"),
                            rs.getString("SurName"),
                            rs.getString("Location"),
                            rs.getString("Date"),
                            rs.getString("Time"),
                            rs.getInt("eventID")

                    )
            );
        }
        else if(val==2){
            return jdbcTemplate.query("select Name,p.FirstName,p.SurName,Location,e.Date,e.Time,e.EventId " +
                            "from Events e inner join People p on p.PeopleId = e.Organiser " +
                            "inner join BookingStatus bs on e.EventId = bs.EventId " +
                            "Inner join People p2 on p2.PeopleId = bs.PeopleId" +
                            " WHERE DATE > NOW() AND p2.email = ? ORDER BY DATE",
                    new Object[]{session.getAttribute("SESSION_USERNAME")},
                    (rs, i) -> new Events(
                            rs.getString("Name"),
                            rs.getString("FirstName"),
                            rs.getString("SurName"),
                            rs.getString("Location"),
                            rs.getString("Date"),
                            rs.getString("Time"),
                            rs.getInt("eventID")

                    )
            );
        }
        else if(val==3){
            return jdbcTemplate.query("select Name,FirstName,SurName,Location,e.Date,e.Time,e.EventId " +
                            "from Events e inner join People p on p.PeopleId = e.Organiser " +
                            "WHERE DATE < NOW() ORDER BY DATE DESC",
                    new Object[]{},
                    (rs, i) -> new Events(
                            rs.getString("Name"),
                            rs.getString("FirstName"),
                            rs.getString("SurName"),
                            rs.getString("Location"),
                            rs.getString("Date"),
                            rs.getString("Time"),
                            rs.getInt("eventID")

                    )
            );
        }
        else if(val==4){
            return jdbcTemplate.query("select Name,p.FirstName,p.SurName,Location,e.Date,e.Time,e.EventId " +
                            "from Events e inner join People p on p.PeopleId = e.Organiser " +
                            "inner join BookingStatus bs on e.EventId = bs.EventId " +
                            "Inner join People p2 on p2.PeopleId = bs.PeopleId " +
                            " WHERE DATE < NOW() AND p2.email = ? ORDER BY DATE DESC",
                    new Object[]{session.getAttribute("SESSION_USERNAME")},
                    (rs, i) -> new Events(
                            rs.getString("Name"),
                            rs.getString("FirstName"),
                            rs.getString("SurName"),
                            rs.getString("Location"),
                            rs.getString("Date"),
                            rs.getString("Time"),
                            rs.getInt("eventID")

                    )
            );
        }
        //if first time page loaded, return default
        else
            return null;

    }
}
