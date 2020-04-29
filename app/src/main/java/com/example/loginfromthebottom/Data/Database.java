package com.example.loginfromthebottom.Data;

import com.example.loginfromthebottom.Model.JobApplicationModel;
import com.example.loginfromthebottom.Model.User;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database implements Serializable {
    private static User admin = new User("admin", "admin",1);
    private static User user1 = new User("jose", "jose",2);
    public static int idJobApp=1;
    private static Database data =null;
    private static List<User> listUser = new ArrayList<>();
    private static List<JobApplicationModel> listOfApplications= new ArrayList<JobApplicationModel>(){
        {
            add(new JobApplicationModel(idJobApp++,"Jonathan","Estrada","Trinidad de Moravia","Urbanizacion Vista Azul","Moravia","San Jose",
                    11443,"Costa Rica","jjestradav@gmail.com","506","71727374","Java developer",new Date(),"/home/jonathan/hola.txt"));
            add(new JobApplicationModel(idJobApp++,"Yamil","Estrada","Trinidad de Moravia","Urbanizacion Vista Azul","Moravia","San Jose",
                    11443,"Costa Rica","yamilestradav@gmail.com","506","71727375","Java developer",new Date(),"/home/jonathan/hola.txt"));
        }
    };

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
