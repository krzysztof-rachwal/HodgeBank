package com.example.demo.Controllers;

import com.example.demo.Data.CreateEvent;
import com.example.demo.Data.CreateEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpSession;

@Controller
public class CreateEventController{
    private CreateEventRepo repo;
    @Autowired
    private JavaMailSender sender;

    @Autowired
    public CreateEventController(CreateEventRepo r) {
        repo = r;
    }

    @GetMapping("/CreateEventPage")
    public String createEventPage(Model model) {
        model.addAttribute("createEvent", new CreateEvent());

        return "CreateEventPage"; //CreateEventsPage.html page name to open it
    }

    @PostMapping("/eventCreation")
    public String greetingSubmit(@ModelAttribute CreateEvent event) {
        repo.addEvent(event);
        repo.setEventID(event);
        repo.addAttendees(event);
        createEventEmail(event);

        return "redirect:/viewSpecificEvent?eventId="+String.valueOf(event.getEventId());
    }

    public void createEventEmail(CreateEvent event) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            for (int i = 0; i < event.getTokenField().size(); i++) {
                System.out.println(i);
                helper.setTo(event.getTokenField().get(i));
                helper.setSubject("You have been invited to " + event.getEventTitle());
                helper.setText("You have been invited to " + event.getEventTitle() +
                        " at " + event.getLocation() + " on " + event.getEventDate() + " at " + event.getEventTime());



                sender.send(message);
            }
        } catch (Exception ex) {
            System.out.println("Error Sending email " + ex);
        }
    }

}


