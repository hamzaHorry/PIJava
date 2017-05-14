/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pi.models;

import java.util.Objects;

/**
 *
 * @author sindamtar
 */
public class User {

    private int id;
    private String username;
    private String email;
    private int enabled;
    private String password;
    private int role;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String username, String email, int enabled, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + this.enabled;
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + this.role;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User:  /n " + "id=" + id + ",  /n username=" + username + ", /n email=" + email + ", /n enabled=" + enabled + ", /n password=" + password + ", /n role=" + role + " /n";
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
