package com.runner.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class RecyclingCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String material;
    private String type;
    private String details;
    private double reward;
    @OneToMany(mappedBy = "category")
    private List<UserHistory> history;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "categoriesSet")
    private Set<Centers> centersSet;


    public RecyclingCategories() {}

    public RecyclingCategories(String name, String material, String type, String details, double reward, List<UserHistory> history, Set<Centers> centersSet) {
        this.name = name;
        this.material = material;
        this.type = type;
        this.details = details;
        this.reward = reward;
        this.history = history;
        this.centersSet = centersSet;
    }

    public List<UserHistory> getHistory() {
        return history;
    }

    public void setHistory(List<UserHistory> history) {
        this.history = history;
    }

    public Set<Centers> getCentersSet() {
        return centersSet;
    }

    public void setCentersSet(Set<Centers> centersSet) {
        this.centersSet = centersSet;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }
}
