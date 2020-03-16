package com.wang.blog.entity;

public class AuthorEntity {

    private int authorid;

    private String name;

    private String country;

    private String borntime;

    private String deadtime;

    private String UUID;

    public AuthorEntity() {

    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public AuthorEntity(int authorid, String name, String country, String borntime, String deadtime) {
        this.authorid = authorid;
        this.name = name;
        this.country = country;
        this.borntime = borntime;
        this.deadtime = deadtime;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBorntime() {
        return borntime;
    }

    public void setBorntime(String borntime) {
        this.borntime = borntime;
    }

    public String getDeadtime() {
        return deadtime;
    }

    public void setDeadtime(String deadtime) {
        this.deadtime = deadtime;
    }
}
