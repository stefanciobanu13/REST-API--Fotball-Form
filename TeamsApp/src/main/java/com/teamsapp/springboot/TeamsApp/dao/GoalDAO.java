package com.teamsapp.springboot.TeamsApp.dao;

import com.teamsapp.springboot.TeamsApp.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalDAO extends JpaRepository<Goal,Integer> {
}
