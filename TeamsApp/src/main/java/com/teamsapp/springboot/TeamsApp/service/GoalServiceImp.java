package com.teamsapp.springboot.TeamsApp.service;

import com.teamsapp.springboot.TeamsApp.dao.GoalDAO;
import com.teamsapp.springboot.TeamsApp.dto.GoalDTO;
import com.teamsapp.springboot.TeamsApp.entity.Goal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoalServiceImp implements GoalService {

    private final GoalDAO goalDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public GoalServiceImp(GoalDAO goalDAO, ModelMapper modelMapper) {
        this.goalDAO = goalDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveGoal(GoalDTO goalDTO) {
        Goal goal = modelMapper.map(goalDTO, Goal.class);
        goalDAO.save(goal);
    }

    @Override
    @Transactional
    public List<GoalDTO> getGoals() {
        List<Goal> goals = goalDAO.findAll();
        return goals.stream()
                .map(goal -> modelMapper.map(goal, GoalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GoalDTO getGoal(int goalId) {
        Optional<Goal> optionalGoal = goalDAO.findById(goalId);
        return optionalGoal.map(goal -> modelMapper.map(goal, GoalDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteGoal(int goalId) {
        goalDAO.deleteById(goalId);
    }
}





