package com.example.demo.Data;

public class PTeam {

    private int personId;
    private int teamId;

    public int getPersonId(){
        return personId;
    }

    public int getTeamId(){
        return teamId;
    }

    public PTeam(int personId, int teamId){
        this.personId = personId;
        this.teamId = teamId;
    }

}
