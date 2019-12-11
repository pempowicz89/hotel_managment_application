package com.company;

public class User {
    private String userName;
    private String password;
    private boolean fullAccess;

    public User(String userName, String password, boolean fullAccess) {
        this.userName = userName;
        this.password = password;
        this.fullAccess = fullAccess;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isFullAccess() {
        return fullAccess;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
