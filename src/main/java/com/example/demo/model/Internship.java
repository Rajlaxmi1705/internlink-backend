package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "internships")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;

    @Column(length = 1000)
    private String description;

    private String duration;
    private String stipend;
    private String location;

    // ✅ REQUIRED by JPA
    public Internship() {
    }

    // ✅ THIS FIXES YOUR ERROR
    public Internship(String title,
                      String company,
                      String description,
                      String duration,
                      String stipend,
                      String location) {
        this.title = title;
        this.company = company;
        this.description = description;
        this.duration = duration;
        this.stipend = stipend;
        this.location = location;
    }

    // getters & setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getStipend() { return stipend; }
    public void setStipend(String stipend) { this.stipend = stipend; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
