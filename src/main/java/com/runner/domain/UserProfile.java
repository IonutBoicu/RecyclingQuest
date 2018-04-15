package com.runner.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    private float achievementPoints;
    @OneToMany(mappedBy = "owner")
    private List<UserHistory> history;

    public UserProfile() {
    }

    public UserProfile(String name, String username, String password, float achievementPoints) {
        this.id = 0L;
        this.name = name;
        this.username = username;
        this.password = password;
        this.achievementPoints = achievementPoints;
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
}
