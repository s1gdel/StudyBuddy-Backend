package com.backend.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "class_data")
public class ClassData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "prof_name", nullable = false)
    private String profName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // Use LocalDateTime for timestamps

    // Default constructor (required by JPA)
    public ClassData() {
    }

    // Parameterized constructor
    public ClassData(String personName, String className, String profName, String description, Double latitude, Double longitude, LocalDateTime createdAt) {
        this.personName = personName;
        this.className = className;
        this.profName = profName;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
    }

    // Automatically set createdAt before persisting the entity
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}