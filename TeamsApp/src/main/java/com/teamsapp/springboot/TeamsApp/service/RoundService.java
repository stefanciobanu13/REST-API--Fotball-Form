package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dto.RoundDTO;
import com.teamsapp.springboot.TeamsApp.entity.Round;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface RoundService {

    void saveRound(RoundDTO roundDTO);

    List<RoundDTO> getRounds();

    RoundDTO getRound(int theId);

    void deleteRound(int theId);

     Round findRoundByNumber(int roundNumber);

    void deleteByNumber(int roundNumber);


}