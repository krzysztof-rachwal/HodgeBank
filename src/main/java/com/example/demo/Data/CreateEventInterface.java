package com.example.demo.Data;

public interface CreateEventInterface {

    /*
    Define the methods that the repository will implement
    */
        int addEvent(CreateEvent createEvent);
        void addAttendees(CreateEvent attendees);
        int getEventId(CreateEvent event);
}
