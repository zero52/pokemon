package com.zhu.modules.sys.entity;/*
2019/9/27
41586
*/

public class User {

    private long id;
    private String username;
    private String password;
    private String roleName;
    private boolean lock;

    public  User(){

    }
    public User(long id,String username,String password,String roleName,boolean lock){
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.lock = lock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }
}
