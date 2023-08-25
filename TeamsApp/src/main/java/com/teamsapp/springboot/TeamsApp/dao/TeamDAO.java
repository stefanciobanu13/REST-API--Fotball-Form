package com.teamsapp.springboot.TeamsApp.dao;

import com.teamsapp.springboot.TeamsApp.dto.TeamDTO;
import com.teamsapp.springboot.TeamsApp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDAO extends JpaRepository<Team, Integer> {


    @Query("SELECT t FROM Team t WHERE t.color = :color")
    TeamDTO findTeamByColor(@Param("color") String color);

    @Query("SELECT t FROM Team t WHERE t.round.id = :roundId")
    List<Team> getTeamsFromRound(@Param("roundId") int roundId);

    @Query("SELECT t FROM Team t WHERE t.round.id = :roundId AND  t.color = :color")
    Team getTeamFromRound(@Param("roundId") int roundId, @Param("color") String color);
    @Modifying
    @Query("DELETE FROM Team t WHERE t.round.id = :roundId")
    void deleteTeamsFromRound(@Param("roundId") int roundId);


}