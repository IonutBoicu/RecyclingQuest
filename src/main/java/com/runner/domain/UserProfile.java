package com.runner.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String username;
    private String password;
    private float achievementPoints;
    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<UserHistory> history;
    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<SensorBin> sensors;

    public UserProfile() {
    }

    public UserProfile(String name, String username, String password, float achievementPoints, List<UserHistory> history, List<SensorBin> sensors) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.achievementPoints = achievementPoints;
        this.history = history;
        this.sensors = sensors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(float achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public List<UserHistory> getHistory() {
        return history;
    }

    public void setHistory(List<UserHistory> history) {
        this.history = history;
    }

    public List<SensorBin> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorBin> sensors) {
        this.sensors = sensors;
    }
}
