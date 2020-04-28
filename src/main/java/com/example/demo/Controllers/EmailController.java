package com.example.demo.Controllers;

import javax.mail.internet.MimeMessage;

import com.example.demo.Emails.EmailList;
import com.example.demo.Emails.EmailListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private JavaMailSender sender;
    private EmailListRepo repo;

    @Autowired
    public EmailController(EmailListRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("/simpleemail")
    @ResponseBody
    String home() {
        try {
            sendEmail();
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: " + ex;
        }
    }




    private void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        List<EmailList> emails = repo.findAll();
        for(EmailList email : emails)
        {
            System.out.println("Test");
            helper.setTo(email.getEmailAdd());
            helper.setText("Hello");
            helper.setSubject("This is a test");

            sender.send(message);
        }


    }
}