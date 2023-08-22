package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dto.TeamDTO;
import java.util.List;

public interface TeamService2 {

    List<TeamDTO> getTeams();
    TeamDTO getTeamById(int teamId);
    TeamDTO createTeam(TeamDTO teamDTO);
    void deleteTeam(int teamId);
}