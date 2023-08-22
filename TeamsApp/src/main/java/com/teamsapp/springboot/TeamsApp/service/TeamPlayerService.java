package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dto.TeamPlayerDTO;
import com.teamsapp.springboot.TeamsApp.entity.TeamPlayer;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface TeamPlayerService {

    void saveTeamPlayer(TeamPlayerDTO teamPlayerDTO);

    List<TeamPlayerDTO> getTeamPlayers();

    TeamPlayerDTO getTeamPlayer(int theId);

    void deleteTeamPlayer(int theId);
}