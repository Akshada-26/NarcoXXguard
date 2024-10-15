package com.example.narcotixguard;

public class Doctor {
    private String name;
    private String specialization;
    private String degree;
    private String email;


    public Doctor(String degree, String email, String name, String specialization) {
        this.degree=degree;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // Add getters and setters as needed
}
