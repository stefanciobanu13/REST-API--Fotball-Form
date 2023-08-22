package com.teamsapp.springboot.TeamsApp.dao;

import com.teamsapp.springboot.TeamsApp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDAO extends JpaRepository<Team, Integer> {


}