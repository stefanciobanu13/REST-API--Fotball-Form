package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.entity.Team;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface TeamService {

    void saveTeam(Team team);

    List<Team> getTeams();

    Team getTeam(int theId);

    void deleteTeam(int theId);
}