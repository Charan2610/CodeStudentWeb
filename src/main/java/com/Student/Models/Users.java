package com.Student.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String username;
    String email;
    String password;
    String  type;

    public Users() {
    }

    public Users(int id, String username, String email, String password, String type) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
