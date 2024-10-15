package com.example.narcotixguard;

public class User {
    private String name;
    private int age;
    private String email;
    private String type; // "patient" or "doctor"

    // Empty constructor for Firebase
    public User() {
    }

    // Constructor for creating a new user
    public User(String name, int age, String email, String type) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.type = type;
    }

    // Getters and setters for each property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}