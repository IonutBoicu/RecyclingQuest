package com.runner.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String details;
    private double weight;
    private String date;
    private String recyclingCenter;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserProfile owner;
    private String material;

    public UserHistory() {

    }

    public UserHistory(String details, double weight, String date, String recyclingCenter, UserProfile owner, String material) {
        this.details = details;
        this.weight = weight;
        this.date = date;
        this.recyclingCenter = recyclingCenter;
        this.owner = owner;
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecyclingCenter() {
        return recyclingCenter;
    }

    public void setRecyclingCenter(String recyclingCenter) {
        this.recyclingCenter = recyclingCenter;
    }

    public UserProfile getOwner() {
        return owner;
    }

    public void setOwner(UserProfile owner) {
        this.owner = owner;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
