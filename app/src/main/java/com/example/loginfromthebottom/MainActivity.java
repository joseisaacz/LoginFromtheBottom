package com.example.loginfromthebottom;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginfromthebottom.Data.Database;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfromthebottom.Model.User;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Database data= Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate a button
        Button loginButton = (Button) findViewById(R.id.loginBtn);
        TextView registerUser =  findViewById(R.id.registerUser);
        TextView changePassword = findViewById(R.id.changePassword);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        // perform click event on the button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Hello AbhiAndroid..!!!", Toast.LENGTH_LONG).show();  // display a toast message
                if (validar()) {
                    User u=null;
                    String user = String.valueOf(username.getText());
                    for(User i: data.getListUser()){
                        if(i.getUsername().equals(user)){
                            u=new User(i.getUsername(),i.getPassword(),i.getRol());
                        }
                    }
                    if (u.getRol()==1) {
                        Toast.makeText(getApplicationContext(), "Hello " + username.getText().toString(), Toast.LENGTH_LONG).show();
                        Intent jobApp = new Intent(getApplicationContext(), ListJobActivity.class);
                        startActivity(jobApp);
                    } else {
                        Toast.makeText(getApplicationContext(), "Exito", Toast.LENGTH_LONG).show();
                        Intent JobApplication = new Intent(getApplicationContext(), JobApplication.class);
                        startActivity(JobApplication);
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Bad Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerUser = new Intent(getApplicationContext(), RegisterUser.class);
                startActivity(registerUser);
            }
        });
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changepassword = new Intent(MainActivity.this.getApplicationContext(), ChangePassword.class);
                changepassword.putExtra("username", String.valueOf(username.getText()));
                MainActivity.this.startActivity(changepassword);
            }
        });

    }

    private boolean validar() {
        String user = String.valueOf(username.getText());
        String pass = String.valueOf(password.getText());
        for (User i : data.getListUser()) {
            if (user.equals(i.getUsername()) && pass.equals(i.getPassword())) {
                return true;
            }
        }
        return false;
    }


}