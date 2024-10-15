package com.example.narcotixguard;

public class Patient {
    private String name;
    private String age;
    private String mobile;
    private String addictionDetails;
    private String addictionYear;
    private String drugType;
    private String email;
    private String userId;
    private String userName;

    // Add getters, setters, and an empty constructor




    public Patient(String name, String age, String mobile, String addictionDetails,String drugType,String userName) {
        this.name=name;
        this.age=age;
        this.mobile=mobile;
        this.addictionDetails=addictionDetails;
        this.drugType=drugType;
        this.userName=userName;

    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public String getAddictionYear() {
        return addictionYear;
    }
    public void setAddictionYear(String addictionYear) {
        this.addictionYear = addictionYear;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddictionDetails() {
        return addictionDetails;
    }

    public void setAddictionDetails(String addictionDetails) {
        this.addictionDetails = addictionDetails;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
// Add getters and setters...
}
