package com.auth.projetologin.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Timestamp loggedAt;

    @Column(nullable = false)
    private Timestamp loggedUntil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(Timestamp loggedAt) {
        this.loggedAt = loggedAt;
    }

    public Timestamp getLoggedUntil() {
        return loggedUntil;
    }

    public void setLoggedUntil(Timestamp loggedUntil) {
        this.loggedUntil = loggedUntil;
    }
}
