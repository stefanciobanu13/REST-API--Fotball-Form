package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dao.TeamDAO;
import com.teamsapp.springboot.TeamsApp.dto.TeamDTO;
import com.teamsapp.springboot.TeamsApp.entity.Team;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl2 implements TeamService2 {

    private TeamDAO teamDAO;
    private ModelMapper modelMapper; // Requires ModelMapper library

    @Autowired
    public TeamServiceImpl2(TeamDAO teamDAO, ModelMapper modelMapper) {
        this.teamDAO = teamDAO;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public List<TeamDTO> getTeams() {
        List<Team> teams = teamDAO.findAll();
        return teams.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public TeamDTO getTeamById(int teamId) {
        Team team = teamDAO.findById(teamId).orElse(null);
        if (team != null) {
            return convertToDto(team);
        }
        return null;
    }
    @Transactional
    @Override
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = convertToEntity(teamDTO);
        Team savedTeam = teamDAO.save(team);
        return convertToDto(savedTeam);
    }

    @Transactional
    @Override
    public void deleteTeam(int teamId) {
        teamDAO.deleteById(teamId);
    }

    @Transactional
    @Override
    public List<TeamDTO> getTeamsFromRound(int roundNumber) {
        List<Team> teams = teamDAO.getTeamsFromRound(roundNumber);

        return teams.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public TeamDTO getTeamFromRound(int roundId, String color) {
        Team team = teamDAO.getTeamFromRound(roundId, color);
        return convertToDto(team);
    }


    @Transactional
    @Override
    public void deleteTeamsFromRound(int roundId) {
        teamDAO.deleteTeamsFromRound(roundId);
    }

    private TeamDTO convertToDto(Team team) {
        return modelMapper.map(team, TeamDTO.class);
    }

    private Team convertToEntity(TeamDTO teamDTO) {
        return modelMapper.map(teamDTO, Team.class);
    }
}