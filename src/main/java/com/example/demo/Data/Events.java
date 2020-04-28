package com.example.demo.Data;

public class Events {

    private int eventID;
    private String eventName;
    private String organiserName;
    private String location;
    private String date;
    private String time;
    private int dReq;
    private int teamBased;
    private String description;
    private int teamSize;
    private String organiserEmail;

    public Events(String name, String firstName, String surName, String location, String date, String time, String description, int eventID, int dietReq, int teamBased, int teamSize, String email) {
    this.eventName = name;
        this.organiserName = firstName + " " + surName;
        this.location = location;
        this.date = date;
        this.time = time;
        this.dReq = dietReq;
        this.teamBased = teamBased;
        this.description = description;
        this.teamSize = teamSize;
        this.organiserEmail = email;
        this.eventID = eventID;
    }

    public int getTeamSize(){
        return teamSize;
    }

    public String getDescription() {
        return description;
    }

    public int getEventID() {
        return eventID;
    }

    public String getTime() {
        return time;
    }

    public String getEventName() {
        return eventName;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public int getDReq() {
        return dReq;
    }

    public int getTeamBased() {
        return teamBased;
    }

    public String getOrganiserEmail() {
        return organiserEmail;
    }

    public void setOrganiserEmail(String organiserEmail) {
        this.organiserEmail = organiserEmail;
    }

    public Events(String eventName, String organiserName, String location, String date, String time, int dReq, int teamBased, String description, int teamSize, String organiserEmail) {
        this.eventName = eventName;
        this.organiserName = organiserName;
        this.location = location;
        this.date = date;
        this.time = time;
        this.dReq = dReq;
        this.teamBased = teamBased;
        this.description = description;
        this.teamSize = teamSize;
        this.organiserEmail = organiserEmail;
    }

    public Events(String eventName, String organiserName, String location, String date, int dReq, int teamBased, int teamSize) {
        this.eventName = eventName;
        this.organiserName = organiserName;
        this.location = location;
        this.date = date;
        this.dReq = dReq;
        this.teamBased = teamBased;
        this.teamSize=teamSize;
    }

    public Events(String eventName, String organiserFN, String organiserSN, String location, String date, String time, int eventID) {

        this.eventName = eventName;
        this.organiserName = organiserFN + " " + organiserSN;
        this.location = location;
        this.date = date;
        this.time = time;
        this.eventID = eventID;
    }

    public Events(String eventName, String organiserFN, String organiserSN, String location, String date, String time, String description, int eventID) {
        this.eventName = eventName;
        this.organiserName = organiserFN + " " + organiserSN;
        this.location = location;
        this.date = date;
        this.time = time;
        this.description = description;
        this.eventID = eventID;
    }

    public Events(String eventName, String organiserFN, String organiserSN, String location, String date, String time, String description, int eventID, int dReq) {
        this.eventName = eventName;
        this.organiserName = organiserFN + " " + organiserSN;
        this.location = location;
        this.date = date;
        this.time = time;
        this.description = description;
        this.eventID = eventID;
        this.dReq=dReq;

    }


    public Events(String eventName, String organiserFN, String organiserSN, String location, String date, String time, String description, int eventID, int dReq, int teamBased, int teamSize) {
        this.eventName = eventName;
        this.organiserName = organiserFN + " " + organiserSN;
        this.location = location;
        this.date = date;
        this.time = time;
        this.description = description;
        this.eventID = eventID;
        this.dReq=dReq;
        this.teamBased=teamBased;
        this.teamSize=teamSize;
    }

    public Events(int eventID){
        this.eventID = eventID;
    }
}
