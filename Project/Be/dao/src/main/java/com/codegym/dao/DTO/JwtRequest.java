package com.codegym.dao.DTO;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private static final long seriaVersionUID = 5926468583005150707L;
    private  String username;
    private  String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static long getSeriaVersionUID() {
        return seriaVersionUID;
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
}
