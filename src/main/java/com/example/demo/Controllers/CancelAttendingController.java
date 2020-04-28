package com.example.demo.Controllers;

import com.example.demo.Data.CancelAttendingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CancelAttendingController {

    //Creating repository instance so that its methods can be accessed
    private CancelAttendingRepo repo;

    @Autowired
    public CancelAttendingController(CancelAttendingRepo repo){
        this.repo = repo;
    }

    /*This method removes the value in the database which matches the eventId
    and redirects the user to the viewEvents page*/
    @PostMapping("/cancelAttending")

    public String cancelAttending(@RequestParam int eventId) {

        repo.cancelAttending(eventId);
        return "redirect:/viewEvents";
    }

}