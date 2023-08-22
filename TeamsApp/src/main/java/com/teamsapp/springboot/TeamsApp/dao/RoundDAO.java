package com.teamsapp.springboot.TeamsApp.dao;

import com.teamsapp.springboot.TeamsApp.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoundDAO extends JpaRepository<Round,Integer> {

    @Query("SELECT g FROM Round g WHERE g.date = :roundDate")
    public Round findByRoundDate(@Param("roundDate") String roundDate);


}
