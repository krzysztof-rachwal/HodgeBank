package com.example.demo.Controllers;

import com.example.demo.Data.DeleteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeleteController {
    
    //Creating repository instance so that its methods can be accessed
    private DeleteRepo repo;

    @Autowired
    public DeleteController (DeleteRepo repo){
        this.repo = repo;
    }

    //This method deletes the row that contains the eventId and redirets the 
    //user to the viewEvent page
    @PostMapping("/delete")
    public String delete(@RequestParam int eventId) {
        repo.delete(eventId);
        return "redirect:/viewEvents";
    }



}
