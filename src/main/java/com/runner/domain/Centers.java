package com.runner.domain;

import javax.persistence.*;
import java.util.Set;

enum collection {
    HOME,
    ATCENTER,
    BOTH,
    PARTNER
}

@Entity
public class Centers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Float latitude, longitude, rating;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="category_center", joinColumns=@JoinColumn(name="center_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
    private Set<RecyclingCategories> categoriesSet;
    private collection typeOfCollection;

    public Centers() {

    }

    public Centers(String name, String phone, String email, Float latitude, Float longitude, Float rating, Set<RecyclingCategories> categoriesSet) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.categoriesSet = categoriesSet;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Set<RecyclingCategories> getCategoriesSet() {
        return categoriesSet;
    }

    public void setCategoriesSet(Set<RecyclingCategories> categoriesSet) {
        this.categoriesSet = categoriesSet;
    }
}
