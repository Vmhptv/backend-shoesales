package com.example.bangiay.dto.respone;

import java.util.List;

public class JwtResponse {
    private String jwt;
    private String type;
    private String username;
    private String email;
    private String hoTen;
    private List<String> roles;

    public JwtResponse(String jwt, String type, String username,String hoTen, String email, List<String> roles) {
        this.jwt = jwt;
        this.type = type;
        this.username = username;
        this.email = email;
        this.hoTen = hoTen;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
