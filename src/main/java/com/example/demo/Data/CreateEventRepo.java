package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.servlet.http.HttpSession;

@Repository
public class CreateEventRepo  implements CreateEventInterface{

    private JdbcTemplate jdbcTemplate;
    HttpSession session;

    @Autowired
    public CreateEventRepo(JdbcTemplate aTemplate, HttpSession session) {
        jdbcTemplate = aTemplate;
        this.session = session;
    }

    public int getSessionID(){
        return jdbcTemplate.queryForObject("select PeopleId from People where Email = ?",
                new Object[]{session.getAttribute("SESSION_USERNAME")},
                (rs,i) -> new Integer(
                        rs.getInt("PeopleId")
                )
        );
    }

    @Override
    public int addEvent(CreateEvent createEvent) {
        int PersonID = getSessionID();
        return jdbcTemplate.update("insert into Events(Name, Organiser, Description, Location, TeamBased, DietReq, Date, Time, TeamSize)  values(?,?,?,?,?,?,?,?,?)",
                createEvent.getEventTitle(),
                PersonID,
                createEvent.getEventDesc(),
                createEvent.getLocation(),
                createEvent.getTeamBased(),
                createEvent.getDietaryReq(),
                createEvent.getEventDate(),
                createEvent.getEventTime(),
                createEvent.getTeamSize());
    }

    //Need to get eventId which is validated in terms of event name and date - there can be reoccurring events with the same name time location and desc.
    public int getEventId(CreateEvent event) {
        return event.getEventId();
    }
    public void setEventID(CreateEvent event){
        event.setEventId(jdbcTemplate.queryForObject("select EventId from Events where Name = ? and Date = ?",
                new Object[]{event.getEventTitle(), event.getEventDate()},
                (rs, i) -> new Integer(
                        rs.getInt("EventId")
                )));
    }

    @Override
    public void addAttendees(CreateEvent attendees) {
        for (int i = 0; i < attendees.getTokenField().size(); i++) {
            jdbcTemplate.update("insert into BookingStatus(PeopleId, eventId, statusId)" +
                            "select People.PeopleId, Events.EventId,? from People, Events " +
                            "where Email = ? and EventId = ?",
                    3,
                    attendees.getTokenField().get(i),
                    attendees.getEventId()); //it should get eventId form the above method
        }

    }


}
