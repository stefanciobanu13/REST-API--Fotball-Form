package com.teamsapp.springboot.TeamsApp.dto;

import com.teamsapp.springboot.TeamsApp.entity.Player;
import com.teamsapp.springboot.TeamsApp.entity.Team;

public class TeamPlayerDTO {

    private int id;
    private int teamId;
    private int playerId;


    public TeamPlayerDTO() {

    }

    public TeamPlayerDTO(int id, int teamId, int playerId) {
        this.id = id;
        this.teamId = teamId;
        this.playerId = playerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}