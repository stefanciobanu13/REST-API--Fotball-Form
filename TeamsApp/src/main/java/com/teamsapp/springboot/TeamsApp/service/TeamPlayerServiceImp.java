package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dao.TeamPlayerDAO;
import com.teamsapp.springboot.TeamsApp.dto.TeamPlayerDTO;
import com.teamsapp.springboot.TeamsApp.entity.TeamPlayer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamPlayerServiceImp implements TeamPlayerService {

    private final TeamPlayerDAO teamPlayerDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public TeamPlayerServiceImp(TeamPlayerDAO teamPlayerDAO, ModelMapper modelMapper) {
        this.teamPlayerDAO = teamPlayerDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveTeamPlayer(TeamPlayerDTO teamPlayerDTO) {
        TeamPlayer teamPlayer = modelMapper.map(teamPlayerDTO, TeamPlayer.class);
        teamPlayerDAO.save(teamPlayer);
    }

    @Override
    @Transactional
    public List<TeamPlayerDTO> getTeamPlayers() {
        List<TeamPlayer> teamPlayers = teamPlayerDAO.findAll();
        return teamPlayers.stream()
                .map(teamPlayer -> modelMapper.map(teamPlayer, TeamPlayerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TeamPlayerDTO getTeamPlayer(int teamPlayerId) {
        Optional<TeamPlayer> optionalTeamPlayer = teamPlayerDAO.findById(teamPlayerId);
        return optionalTeamPlayer.map(teamPlayer -> modelMapper.map(teamPlayer, TeamPlayerDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteTeamPlayer(int teamPlayerId) {
        teamPlayerDAO.deleteById(teamPlayerId);
    }
}