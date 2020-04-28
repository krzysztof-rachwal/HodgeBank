package com.example.demo;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WebAppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/login")).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Username")));
    }

    @Test
    public void a_testGreeting() throws Exception {
        this.mockMvc.perform(get("/delete")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("redirect:/viewEvents")));
    }

    //    Component test using a mock MVC but a test database
    @org.junit.Test
    public void data() throws Exception {
        this.mockMvc.perform(get("/viewEvents")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("testdb1")));
    }

    //    Component test using a mock MVC but a test database
    @org.junit.Test
    public void menuPage() throws Exception {
        this.mockMvc.perform(get("/public/menu")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("testdb1")));
    }

    //    Component test using a mock MVC but a test database
    @org.junit.Test
    public void menuItem() throws Exception {
        this.mockMvc.perform(get("/api/menu/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("testdb1")));
    }

}


