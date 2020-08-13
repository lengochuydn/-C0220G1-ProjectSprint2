package com.codegym.dao.DTO;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private  String acountName;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
    public String getToken() {
        return this.jwttoken;
    }

    public JwtResponse(String jwttoken, String acountName, Collection<? extends GrantedAuthority> authorities) {
        this.jwttoken = jwttoken;
        this.acountName = acountName;
        this.authorities = authorities;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getAcountName() {
        return acountName;
    }

    public void setAcountName(String acountName) {
        this.acountName = acountName;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
