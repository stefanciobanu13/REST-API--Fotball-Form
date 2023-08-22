package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dto.GameDTO;

import java.util.List;

public interface GameService {

    void saveGame(GameDTO gameDTO);

    List<GameDTO> getGames();

    GameDTO getGame(int gameId);

    void deleteGame(int gameId);
}