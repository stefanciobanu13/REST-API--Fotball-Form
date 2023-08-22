package com.teamsapp.springboot.TeamsApp.dao;

import com.teamsapp.springboot.TeamsApp.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDAO extends JpaRepository<Game,Integer> {

}
