package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dao.GameDAO;
import com.teamsapp.springboot.TeamsApp.dto.GameDTO;
import com.teamsapp.springboot.TeamsApp.entity.Game;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImp implements GameService {

    private final GameDAO gameDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImp(GameDAO gameDAO, ModelMapper modelMapper) {
        this.gameDAO = gameDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveGame(GameDTO gameDTO) {
        Game game = modelMapper.map(gameDTO, Game.class);
        gameDAO.save(game);
    }

    @Override
    @Transactional
    public List<GameDTO> getGames() {
        List<Game> games = gameDAO.findAll();
        return games.stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GameDTO getGame(int gameId) {
        Optional<Game> optionalGame = gameDAO.findById(gameId);
        return optionalGame.map(game -> modelMapper.map(game, GameDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteGame(int gameId) {
        gameDAO.deleteById(gameId);
    }
}