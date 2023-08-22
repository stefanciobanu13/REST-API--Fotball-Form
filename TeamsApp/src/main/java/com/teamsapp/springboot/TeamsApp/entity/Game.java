package com.teamsapp.springboot.TeamsApp.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name ="game")
@Entity
@Component
public class Game {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team1_id")
    private Team team1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team2_id")
    private Team team2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id")
    private Round round;

    @Column(name = "team1_goals")
    private int team1_goals = 0;

    @Column(name = "team2_goals")
    private int team2_goals = 0;

    @Column(name = "number")
    private int number;

    //constructors
    public Game(){}

    public Game(int id, int number, Team team1, Team team2, Round round, int team1_goals, int team2_goals) {
        this.id = id;
        this.number = number;
        this.team1 = team1;
        this.team2 = team2;
        this.round = round;
        this.team1_goals = team1_goals;
        this.team2_goals = team2_goals;
    }

    public Game(Team team1, Team team2, int team1_goals, int team2_goals, Round round, int number) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1_goals = team1_goals;
        this.team2_goals = team2_goals;
        this.round = round;
        this.number= number;
    }

    public Game(Team team1, Team team2, Round round){
        this.team1 = team1;
        this.team2 = team2;
        this.round = round;
    }


    //getters and setters


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTeam1_goals() {
        return team1_goals;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getTeam2_goals() {
        return team2_goals;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeam1_goals(int team1Goals) {
        this.team1_goals = team1Goals;
    }

    public void setTeam2_goals(int team2Goals) {
        this.team2_goals = team2Goals;
    }
}
