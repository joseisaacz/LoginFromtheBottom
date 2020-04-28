package com.example.loginfromthebottom.Model;

public class User {
    private String username;
    private String password;
    private int rol;
    public User(){
        username=" ";
        password=" ";
        rol=0;
    };
    public User(String _username, String _password, int _rol){
        username=_username;
        password=_password;
        rol=_rol;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String _username){
        username=_username;
    }
    public void setPassword(String _password){
        password=_password;
    }
    public int getRol(){return rol;}
    public void setRol(int _rol){rol=_rol;}
}
