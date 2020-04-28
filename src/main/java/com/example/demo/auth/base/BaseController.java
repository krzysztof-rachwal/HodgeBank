package com.example.demo.auth.base;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    @GetMapping("/")
    public ModelAndView home(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("loginTemplate");
        return mv;
    }

    /*@GetMapping("/viewEvents")
    public ModelAndView userArea(HttpSession session) {
        //For debugging, loop through the session attributes and print them
        /*Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("viewEvents");
        return mv;
    }*/

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        new SecurityContextLogoutHandler().logout(request, null, null);
        return "redirect:/";
    }



    @RequestMapping("/eventPage")
    public String eventPage() {
        return "eventPage"; //eventPage.html page name to open it
    }

}
