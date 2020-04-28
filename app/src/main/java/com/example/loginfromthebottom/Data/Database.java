package com.example.loginfromthebottom.Data;

import com.example.loginfromthebottom.Model.JobApplicationModel;
import com.example.loginfromthebottom.Model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
    private static User admin = new User("admin", "admin",1);
    private static User user1 = new User("jose", "jose",2);
    private static Database data =null;
    private  static List<User> listUser = new ArrayList<User>();
    private static List<JobApplicationModel> listOfApplications = new ArrayList<>();
    private Database(){
        listUser.add(admin);
        listUser.add(user1);
    }
    public static Database getInstance(){
        if(data==null)
            return new Database();
        else return data;
    }
    public static List<User> getListUser() {
        return listUser;
    }
    public static List<JobApplicationModel> getListOfApplications() {
        return listOfApplications;
    }

}
