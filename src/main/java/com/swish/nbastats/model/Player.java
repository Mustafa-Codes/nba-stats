package com.swish.nbastats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.util.LinkedList;

@Entity
public class Player {

    @Id
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String team;
    private String position;
    private Double pointsPerGame;
    private Double assistsPerGame;
    private Double reboundsPerGame;

    @Version  // This will track the version of the entity for optimistic locking
    private Long version;

    // Public no-argument constructor for JPA
    public Player() {}

    // Constructor
    public Player(Long id, String name, String team, String position, double pointsPerGame,
                  double assistsPerGame, double reboundsPerGame) {

        // Validate points, assists, and rebounds per game are non-negative numbers
        if (pointsPerGame < 0 || assistsPerGame < 0 || reboundsPerGame < 0) {
            throw new IllegalArgumentException("Stats cannot be negative");
        }

        this.id = id;
        this.name = name;
        this.team = team;
        this.position = position;
        this.pointsPerGame = pointsPerGame;
        this.assistsPerGame = assistsPerGame;
        this.reboundsPerGame = reboundsPerGame;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public double getPointsPerGame() {
        return pointsPerGame;
    }

    public double getAssistsPerGame() {
        return assistsPerGame;
    }

    public double getReboundsPerGame() {
        return reboundsPerGame;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPointsPerGame(double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    public void setAssistsPerGame(double assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }

    public void setReboundsPerGame(double reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }

    // Method to calculate average points per game

    // Override toString() for better debug output
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                ", pointsPerGame=" + pointsPerGame +
                ", assistsPerGame=" + assistsPerGame +
                ", reboundsPerGame=" + reboundsPerGame +
                '}';
    }
}
