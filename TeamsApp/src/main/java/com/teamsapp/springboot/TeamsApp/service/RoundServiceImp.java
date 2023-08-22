package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dao.RoundDAO;
import com.teamsapp.springboot.TeamsApp.dto.RoundDTO;
import com.teamsapp.springboot.TeamsApp.entity.Round;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoundServiceImp implements RoundService {

    private final RoundDAO roundDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public RoundServiceImp(RoundDAO roundDAO, ModelMapper modelMapper) {
        this.roundDAO = roundDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveRound(RoundDTO roundDTO) {
        Round round = modelMapper.map(roundDTO, Round.class);
        roundDAO.save(round);
    }

    @Override
    @Transactional
    public List<RoundDTO> getRounds() {
        List<Round> rounds = roundDAO.findAll();
        return rounds.stream()
                .map(round -> modelMapper.map(round, RoundDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RoundDTO getRound(int theId) {
        Optional<Round> optionalRound = roundDAO.findById(theId);
        return optionalRound.map(round -> modelMapper.map(round, RoundDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteRound(int theId) {
        roundDAO.deleteById(theId);
    }

    @Override
    public Round findByRoundDate(String roundDate) {
        return roundDAO.findByRoundDate(roundDate);
    }
}