package com.example.demo.Controllers;

import com.example.demo.Data.Events;
import com.example.demo.Data.SearchEventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    private SearchEventsRepo repo;

    public SearchController (SearchEventsRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/viewEvents")
    public ModelAndView getEvents(@RequestParam(defaultValue = "1") int selectSQL) {
        ModelAndView mv = new ModelAndView("viewEvents");
        List<Events> myEvent = repo.findByEvent(selectSQL);
        mv.addObject("myEvent", myEvent);
        return mv;
    }

}