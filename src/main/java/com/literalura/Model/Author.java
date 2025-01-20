package com.literalura.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Author {

    @Id
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }
}
