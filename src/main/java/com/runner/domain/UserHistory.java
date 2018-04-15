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
    private Date date;
    private String recyclingCenter;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserProfile owner;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private RecyclingCategories category;

    public UserHistory() {

    }

    public UserHistory(String details, double weight, Date date, String recyclingCenter, UserProfile owner, RecyclingCategories material) {
        this.details = details;
        this.weight = weight;
        this.date = date;
        this.recyclingCenter = recyclingCenter;
        this.owner = owner;
        this.category = material;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public RecyclingCategories getMaterial() {
        return category;
    }

    public void setMaterial(RecyclingCategories category) {
        this.category = category;
    }
}
