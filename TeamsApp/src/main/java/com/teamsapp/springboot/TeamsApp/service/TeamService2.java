package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dto.TeamDTO;
import com.teamsapp.springboot.TeamsApp.entity.Team;

import java.util.List;

public interface TeamService2 {

    List<TeamDTO> getTeams();
    TeamDTO getTeamById(int teamId);
    TeamDTO createTeam(TeamDTO teamDTO);
    void deleteTeam(int teamId);

    List<TeamDTO> getTeamsFromRound(int roundId);

     TeamDTO getTeamFromRound(int roundId, String color);

    void deleteTeamsFromRound(int roundId);
}