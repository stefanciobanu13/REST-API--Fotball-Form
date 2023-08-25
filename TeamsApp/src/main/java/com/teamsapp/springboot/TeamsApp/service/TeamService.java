package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dto.TeamDTO;
import com.teamsapp.springboot.TeamsApp.entity.Team;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface TeamService {

    void saveTeam(Team team);

    List<Team> getTeams();

    Team getTeam(int theId);

    void deleteTeam(int theId);

    TeamDTO findTeamByColor(String color);

    void deleteTeamsFromRound(int roundId);
}