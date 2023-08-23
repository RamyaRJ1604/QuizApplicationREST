package com.mylearning.quizapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "enabled")
    private int userEnabled;
    @Column(name = "user_role")
    private String userRole;

    public User(){

    }

    public User(String userName, String userPassword, int userEnabled, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEnabled = userEnabled;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(int userEnabled) {
        this.userEnabled = userEnabled;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEnabled=" + userEnabled +
                ", userRole=" + userRole +
                '}';
    }
}
