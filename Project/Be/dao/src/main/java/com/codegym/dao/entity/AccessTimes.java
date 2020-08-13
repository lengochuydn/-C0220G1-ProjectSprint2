package com.codegym.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "access_times")
public class AccessTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "ip_user")
    private String ipUser;

    public AccessTimes() {
    }

    public AccessTimes(Date date, String ipUser) {
        this.date = date;
        this.ipUser = ipUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIpUser() {
        return ipUser;
    }

    public void setIpUser(String ipUser) {
        this.ipUser = ipUser;
    }

}
