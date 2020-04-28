package com.example.demo.Controllers;
import org.springframework.stereotype.Controller;
import com.example.demo.Data.CreateEventRepo;
import com.example.demo.Data.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CreateEventController {

    private CreateEventRepo repo;

    @Autowired
    public CreateEventController (CreateEventRepo repo) {this.repo = repo; }

    @GetMapping("/addEvent")
    @ResponseBody
        public String addEvent(@RequestParam String eventName, String organiser, String location,String description, String date,String time, boolean dReq, boolean teamBased){

        Event newEvent= new Event(eventName,organiser,location,description,date, time, teamBased,dReq);
        repo.addEvent(newEvent);
        return "redirect:/eventPage.html";
    }
}
