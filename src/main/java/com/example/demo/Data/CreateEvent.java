package com.example.demo.Data;

import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class CreateEvent {
    private int eventId;
    private String eventTitle;
    private String eventDesc;
    private String location;
    private String eventTime;
    private Date eventDate;
    private List<String> tokenField;
    private int dietaryReq;
    private int teamSize;
    private int teamBased;

    public CreateEvent() {
    }

    public CreateEvent(int eventId, String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, String tokenField, int dietaryReq, int teamBased) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        //this.tokenField = tokenField;
        this.tokenField = Arrays.asList(tokenField.split("\\s*,\\s*")); //changing email addresses String to an ArrayList
        this.dietaryReq = dietaryReq;
        this.teamBased = teamBased;
    }
    public CreateEvent(String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, String tokenField, int dietaryReq, int teamBased) {
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        //this.tokenField = tokenField;
        this.tokenField = Arrays.asList(tokenField.split("\\s*,\\s*")); //changing email addresses String to an ArrayList
        this.dietaryReq = dietaryReq;
        this.teamBased = teamBased;
        this.teamSize = 0;
    }
    public CreateEvent(String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, int dietaryReq, int teamBased) {
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.dietaryReq = dietaryReq;
        this.teamBased = teamBased;
        this.teamSize = 0;
    }

    public CreateEvent(String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, int dietaryReq, int teamSize, int teamBased) {
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.dietaryReq = dietaryReq;
        this.teamSize = teamSize;
        this.teamBased = teamBased;
    }

    public CreateEvent(int eventId, String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, String tokenField, int dietaryReq, int teamSize, int teamBased) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        //this.tokenField = tokenField;
        this.tokenField = Arrays.asList(tokenField.split("\\s*,\\s*")); //changing email addresses String to an ArrayList
        this.dietaryReq = dietaryReq;
        this.teamSize = teamSize;
        this.teamBased = teamBased;
    }
    public CreateEvent(String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, String tokenField, int dietaryReq, int teamSize, int teamBased) {
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        //this.tokenField = tokenField;
        this.tokenField = Arrays.asList(tokenField.split("\\s*,\\s*")); //changing email addresses String to an ArrayList
        this.dietaryReq = dietaryReq;
        this.teamSize = teamSize;
        this.teamBased = teamBased;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<String> getTokenField() {
        return tokenField;
    }

    public void setTokenField(List<String> tokenField) {
        this.tokenField = tokenField;
    }

    public int getDietaryReq() {
        return dietaryReq;
    }

    public void setDietaryReq(int dietaryReq) {
        this.dietaryReq = dietaryReq;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public int getTeamBased() {
        return teamBased;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public void setTeamBased(int teamBased) {
        this.teamBased = teamBased;
    }
}
