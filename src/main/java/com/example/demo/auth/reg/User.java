package com.example.demo.auth.reg;
public class User {

    public int id;
    private String email;

    private String password;

    private String cpassword;

    private String fName;
    private String sName;

    public User() {
    }

    public User(String email, String password, String cpassword, String fName, String sName) {
        this.email = email;
        this.password = password;
        this.cpassword = cpassword;
        this.fName = fName;
        this.sName = sName;
    }

    public User(String username, String password, String cpassword) {
        this.email = username;
        this.password = password;
        this.cpassword = cpassword;
    }


    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
