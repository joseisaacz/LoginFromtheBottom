package com.example.loginfromthebottom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfromthebottom.Data.Database;
import com.example.loginfromthebottom.Model.User;

public class RegisterUser extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .8));
        Button registerUser = (Button) findViewById(R.id.registerUserButton);
        username = (EditText) findViewById(R.id.userNameReg);
        password = (EditText) findViewById(R.id.passwordReg);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordReg);
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empty()){
                if (passwordConfirmation()) {
                    String user= String.valueOf(username.getText());
                    String pass = String.valueOf(password.getText());
                    for(User i: Database.listUser){
                        if(user.equals(i.getUsername())){ Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_LONG).show();
                        finish();}
                    }
                    User nuevo = new User(user,pass,2);
                    Database.listUser.add(nuevo);
                    Intent login = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(login);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Password Confirmation Invalid", Toast.LENGTH_LONG).show();
                    confirmPassword.setText("");
                }

            }else{
                Toast.makeText(getApplicationContext(), "You have to fill the form", Toast.LENGTH_LONG).show();
            }
            }
        });
    }

    private boolean empty() {
        String pass = String.valueOf(password.getText());
        String user = String.valueOf(username.getText());
        String confpass= String.valueOf(confirmPassword.getText());
        if(pass.isEmpty()||user.isEmpty()||confpass.isEmpty()){
            return false;
        }
        return true;
    }

    private boolean passwordConfirmation() {
        String pass = String.valueOf(password.getText());
        String confpass = String.valueOf(confirmPassword.getText());
        if (pass.equals(confpass)) {
            return true;
        } else {
            return false;
        }
    }
}
