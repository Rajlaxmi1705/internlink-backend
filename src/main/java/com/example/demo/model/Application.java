package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // Applicant Details
    // =========================
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private Double sscMarks;
    private Double hscMarks;

    private String college;

    @Column(nullable = false)
    private String resumePath;

    // =========================
    // Internship Mapping
    // =========================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internship_id", nullable = false)
    private Internship internship;

    // =========================
    // REQUIRED BY JPA
    // =========================
    public Application() {
    }

    // =========================
    // CONSTRUCTOR USED IN CONTROLLER
    // =========================
    public Application(
            String name,
            String email,
            Double sscMarks,
            Double hscMarks,
            String college,
            String resumePath,
            Internship internship
    ) {
        this.name = name;
        this.email = email;
        this.sscMarks = sscMarks;
        this.hscMarks = hscMarks;
        this.college = college;
        this.resumePath = resumePath;
        this.internship = internship;
    }

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSscMarks() {
        return sscMarks;
    }

    public void setSscMarks(Double sscMarks) {
        this.sscMarks = sscMarks;
    }

    public Double getHscMarks() {
        return hscMarks;
    }

    public void setHscMarks(Double hscMarks) {
        this.hscMarks = hscMarks;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }
}
