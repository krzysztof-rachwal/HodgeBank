package com.example.demo.Data;

public class Event {

    private int eventID;
    private String eventName;
    private String organiser;
    private String location;
    private String description;
    private String date;
    private String time;
    private boolean dReq;
    private boolean teamBased;

    public int getEventID (){
        return eventID;
    }

    public String getEventName(){
        return eventName;
    }

    public String getOrganiser(){
        return organiser;
    }

    public String getLocation(){
        return location;
    }

    public String getDescription(){ return description; }

    public String getDate(){
        return date;
    }

    public String getTime() { return time; }

    public boolean getDReq(){
        return dReq;
    }

    public boolean getTeamBased(){
        return teamBased;
    }

    public Event (String eventName, String organiser, String location,String description, String date,String time, boolean dReq, boolean teamBased){
        this.eventName = eventName;
        this.organiser = organiser;
        this.location = location;
        this.description = description;
        this.date = date;
        this.time = time;
        this.dReq = dReq;
        this.teamBased = teamBased;
    }

}
