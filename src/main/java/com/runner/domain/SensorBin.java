package com.runner.domain;


import javax.persistence.*;

@Entity
public class SensorBin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String material;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfile owner;
    private Float percentage;

    public SensorBin(String material, UserProfile owner, Float percentage) {
        this.material = material;
        this.owner = owner;
        this.percentage = percentage;
    }

    public SensorBin(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public UserProfile getOwner() {
        return owner;
    }

    public void setOwner(UserProfile owner) {
        this.owner = owner;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
