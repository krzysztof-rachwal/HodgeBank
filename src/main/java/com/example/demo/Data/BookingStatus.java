package com.example.demo.Data;
public class BookingStatus {
    private int bookingStatusId;
    private int peopleId;
    private int eventId;
    private int statusId;
    private String dietReq;
    private String name;
    private String teamMembers;

    public BookingStatus(int peopleID) {
        this.peopleId = peopleID;
    }

    public BookingStatus(int eventId, int statusId, String dietReq) {
        this.eventId = eventId;
        this.statusId = statusId;
        this.dietReq = dietReq;
    }

    public int getBookingStatusId(){
        return bookingStatusId;
    }
    public int getPeopleId(){
        return peopleId;
    }
    public int getEventId(){
        return eventId;
    }
    public int getStatusId(){
        return statusId;
    }
    public String getDietReq(){
        return dietReq;
    }
    public String getName() {
        return name;
    }
    public void setPeopleFN(String name) {
        this.name = name;
    }
    public String getTeamMembers(){
        return teamMembers;
    }


    public BookingStatus (int bookingStatusId, int peopleId, int eventId, int statusId, String dietReq){
        this.bookingStatusId = bookingStatusId;
        this.peopleId = peopleId;
        this.eventId = eventId;
        this.statusId = statusId;
        this.dietReq = dietReq;
        this.name = "";
    }
    public BookingStatus (String firstName, String surName, String dietReq, String teamMembers){
        this.name = firstName + " " + surName;
        this.dietReq = dietReq;
        this.teamMembers=teamMembers;
    }

    public BookingStatus(int peopleId, int eventId, int statusId, String dietReq, String teamMembers){
        this.peopleId = peopleId;
        this.eventId = eventId;
        this.statusId = statusId;
        this.dietReq = dietReq;
        this.teamMembers=teamMembers;
    }

    public BookingStatus(int eventId, int statusId, String dietReq, String teamMembers){
        this.eventId = eventId;
        this.statusId = statusId;
        this.dietReq = dietReq;
        this.teamMembers=teamMembers;
    }
}
