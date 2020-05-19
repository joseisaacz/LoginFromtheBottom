package com.example.loginfromthebottom.Data;

import com.example.loginfromthebottom.JobApplication;
import com.example.loginfromthebottom.Model.JobApplicationModel;
import com.example.loginfromthebottom.Model.User;

import java.io.File;
import java.io.Serializable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database implements Serializable {
    public static String currentUser="";
    private static User admin = new User("admin", "admin",1);
    private static User user1 = new User("jose", "jose",2);
    private static User user2 = new User("jonathan", "jonathan",2);
    public static int idJobApp=1;
    private static Database data =null;
    public static List<User> listUser = new ArrayList<User>(){
        {
            add(admin);
            add(user1);
            add(user2);
        }
    };


    private static List<JobApplicationModel> initJonathan= new ArrayList<JobApplicationModel>(){
        {
            add(new JobApplicationModel(idJobApp++,"Jonathan","Estrada","Trinidad de Moravia","Urbanizacion Vista Azul","Moravia","San Jose",
                    11443,"Costa Rica","jjestradav@gmail.com","506","71727374","Java Developer",new Date(),"/home/jonathan/hola.txt"));

        }
    };
    private static List<JobApplicationModel> initJose= new ArrayList<JobApplicationModel>(){
        {
            add(new JobApplicationModel(idJobApp++,"Jose","Zeledon","Trinidad de Moravia","Por la iglesia","Moravia","San Jose",
                    11443,"Costa Rica","jisaac@gmail.com","506","81828384",".NET Developer",new Date(),"/home/Jose/cv.pdf"));

        }
    };

    private static Map<String,List<JobApplicationModel>> map= new HashMap<String,List<JobApplicationModel>>(){
        {
            put("jonathan",initJonathan);
            put("jose",initJose);
        }
    };

//
//    private Database(){
//        listUser.add(admin);
//        listUser.add(user1);
//    }
//    public static Database getInstance(){
//        if(data==null)
//            return new Database();
//        else return data;
//    }
//    //public static List<User> getListUser() {
//        return listUser;
//    }
    public static Map<String,List<JobApplicationModel>> getMap() {
        return map;
    }
    public static List<JobApplicationModel> getAllApplications(){
        List<JobApplicationModel> result= new ArrayList<>();
        for(Map.Entry<String,List<JobApplicationModel>> entry: map.entrySet()){
            for(JobApplicationModel model : entry.getValue()){
                result.add(model);
            }
        }
        return result;
    }

    public static List<JobApplicationModel> getJobApplicationsByUserName(String username){
        if(map.containsKey(username))
            return map.get(username);

        return new ArrayList<>();
    }

    public static void deleteJobApplication(int id){
        for(Map.Entry<String, List<JobApplicationModel>> entry: map.entrySet()){
            for(JobApplicationModel model : entry.getValue()){
                if(model.getId()==id)
                    entry.getValue().remove(model);
            }
        }
    }

}
