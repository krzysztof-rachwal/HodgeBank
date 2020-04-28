package com.example.demo.Data;

import java.util.List;

public interface SearchDatabaseInterface {

    List<BookingStatus> findByEvent(int eventId);

    List<Events> showByEventId(int eventId);


}
