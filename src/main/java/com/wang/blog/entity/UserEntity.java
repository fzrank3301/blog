package com.wang.blog.entity;


import java.util.List;

public class UserEntity {

    private Integer uid;
    private String username;
    private String password;
    private String email;
    private String phonenumber;
    private String UUID;
    private boolean banned = false;
    private String createtime;
    private List<Integer> uploadList;

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public List<Integer> getUploadList() {
        return uploadList;
    }

    public void setUploadList(List<Integer> uploadList) {
        this.uploadList = uploadList;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", UUID='" + UUID + '\'' +
                ", banned=" + banned +
                ", createtime='" + createtime + '\'' +
                ", uploadList=" + uploadList +
                '}';
    }
}
