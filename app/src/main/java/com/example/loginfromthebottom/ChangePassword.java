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

public class ChangePassword extends AppCompatActivity {
    private Database data= Database.getInstance();
    private String user;
    private EditText oldpass;
    private EditText newpass;
    private EditText confnewpass;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .8));
        user=getIntent().getStringExtra("username");
        oldpass = findViewById(R.id.oldPassword);
        newpass = findViewById(R.id.newPassword);
        confnewpass = findViewById(R.id.confirmnewPasswordReg);
        register = findViewById(R.id.registerCPButton);
        if(user.isEmpty()){
            Toast.makeText(getApplicationContext(), "You did not type a User in the UserName field", Toast.LENGTH_LONG).show();
            Intent login = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(login);
            finish();
        }
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(oldPasswordConfirmation()){
                    if(passwordConfirmation()){
                        String oldpassw = String.valueOf(oldpass.getText());
                        String pass = String.valueOf(newpass.getText());
                        for(User i: data.getListUser()){
                            if(user.equals(i.getUsername())&&oldpassw.equals(i.getPassword())){
                                i.setPassword(pass);
                                Toast.makeText(getApplicationContext(), "Password Changed Successfully", Toast.LENGTH_LONG).show();
                                Intent login = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(login);
                                finish();
                                return;
                            }
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password Confirmation Invalid", Toast.LENGTH_LONG).show();
                        confnewpass.setText("");
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "The old password is incorrect", Toast.LENGTH_LONG).show();
                    Intent login = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(login);
                    finish();
                }
            }
        });
    }

    private boolean passwordConfirmation() {
        String pass = String.valueOf(newpass.getText());
        String confpass = String.valueOf(confnewpass.getText());
        if (pass.equals(confpass)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean oldPasswordConfirmation() {
        for(User i: data.getListUser()) {
            if (String.valueOf(oldpass.getText()).equals(i.getPassword())){
                return true;
            }
        }
        return false;
        }
}
