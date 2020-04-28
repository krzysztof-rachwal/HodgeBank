//package com.example.demo.controllers;
//
//import com.example.demo.Controllers.CreateEventController;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(CreateEventController.class)
//public class IntegrationTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void eventCreationTest() throws Exception {
//        mvc.perform(get("/eventCreation").accept(MediaType.TEXT_PLAIN))
//                .andExpect(status().isOk())
//                .andExpect(view().name("hello"))
//                .andExpect(model().attribute("user", is("World")));
//
//    }
//}
