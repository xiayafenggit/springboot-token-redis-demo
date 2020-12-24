package com.bean;

import java.io.Serializable;

public class Users implements Serializable {
    private Integer uid;
    private String uname;
    private String passwd;

    public Users() {
    }

    public Users(Integer uid, String uname, String passwd) {
        this.uid = uid;
        this.uname = uname;
        this.passwd = passwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
