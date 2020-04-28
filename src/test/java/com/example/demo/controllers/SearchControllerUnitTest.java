//package com.example.demo.controllers;
//
//import com.example.demo.Controllers.CreateEventController;
//import com.example.demo.Controllers.SearchController;
////import org.junit.jupiter.api.Test;
//import com.example.demo.Data.CreateEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.ui.Model;
//import org.springframework.validation.support.BindingAwareModelMap;
//import static org.junit.Assert.*;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
////
////public class SearchControllerUnitTest {
////
////    @Autowired
////    private MockMvc mockMvc;
////
////    @Test
////    public void shouldReturnDefaultMessage() throws Exception {
////        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
////                .andExpect(content().string(containsString("<!DOCTYPE html>")));
////    }
////
////    @Test
////    public void testPersonId() {
////        CreateEventController test = new CreateEventController();
////
////        String result = test.("one", "two");
////
////        assertEquals("onetwo", result);
////
////    }
////
////    @Test
////    public void shouldRe() throws Exception {
////        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
////                .andExpect(content().string(containsString("<!DOCTYPE html>")));
////    }
////}
