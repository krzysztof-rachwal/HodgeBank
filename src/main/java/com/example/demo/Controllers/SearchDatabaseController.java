package com.example.demo.Controllers;
import com.example.demo.Data.Events;
import com.example.demo.Data.BookingStatus;
import com.example.demo.Data.SearchDatabaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


    @RestController
    public class SearchDatabaseController {

        //Creating a respository instance so that its methods can be accessed.
        private SearchDatabaseRepo repo;

        @Autowired
        public SearchDatabaseController (SearchDatabaseRepo repo) {
            this.repo = repo;
        }

        /*This method creates a list of people who are
        signed up to the event (myPeople) using the findByEvent() method in the
        SearchDatabaseRepository. It also creates a list of the event details (myEvent) using the
        showByEventId() method in the SearchDatabaseRepository. Lists are added to the Model and View.
        The template "returnmyAttendees" shows the people signed up to the event and their dietery
        requirements.
         */

        @GetMapping("/searchMyEvents")
        public ModelAndView getEventAttendees(@RequestParam int eventId) {
            ModelAndView mv = new ModelAndView("returnMyAttendees");
            List<BookingStatus> myPeople = repo.findByEvent(eventId);
            List<Events> myEvent = repo.showByEventId(eventId);
            mv.addObject("myEvent", myEvent);
            mv.addObject("myPeople", myPeople);
            return mv;
        }

         /*This method creates a list of event details (myEvent) using showByEventId method in the
         SearchDatabaseRepository and adds it to the Model and View. The template 'eventPage' displays the even details.
         */

        @GetMapping("/viewSpecificEvent")
        public ModelAndView viewSpecificEvent(@RequestParam int eventId) {
            ModelAndView mv = new ModelAndView("eventPage");
            List<Events> myEvent = repo.showByEventId(eventId);
            mv.addObject("myEvent", myEvent);
            return mv;
        }

    }