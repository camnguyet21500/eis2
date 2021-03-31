package com.dxc.user.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "active")
    private boolean active;

    @NotNull
    @Column(name = "username")
    @Size(min = 6, max = 12)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name="fullname")
    @Size(min = 6, max = 30)
    private String fullname;

    @NotNull
    @Column(name="address")
    @Size(min = 10, max = 100)
    private String address;

    @NotNull
    @Column(name="email")
    private String email;
    
    @Column(name="limit_consume")
    private float limit_consume;

    @NotNull
    @Column(name = "role")
    private String role = "user";

    @Column(name = "verification_code", updatable = false)
    private String verification_code;

    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String setRole(String role) {
        this.role = role;
        return role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getLimit_consume() {
        return limit_consume;
    }

    public void setLimit_consume(float limit_consume) {
        this.limit_consume = limit_consume;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }
}

