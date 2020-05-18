package com.example.loginfromthebottom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfromthebottom.Data.Database;
import com.example.loginfromthebottom.Model.JobApplicationModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewJobApplication extends AppCompatActivity {
    /*cancel.findViewById(R.id.cancel_action);
        cancel.setActivated(false);*/
    TextView firstName;
    TextView lastName;
    TextView streetAddress;
    TextView streetAddressSecondLineII;
    TextView city;
    TextView stateOrProvince;
    TextView postalCode;
    TextView country;
    TextView email;
    TextView areaCode;
    TextView phone;
    TextView applyingJob;
    TextView startDate;
    TextView fileName;
    ImageButton cancel;
    JobApplicationModel app;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_application);
        Intent intent= getIntent();
        app= (JobApplicationModel) intent.getSerializableExtra("application");
        firstName = findViewById(R.id.fisrtName_view);
        lastName = findViewById(R.id.lastName);
        streetAddress= findViewById(R.id.address1);
        streetAddressSecondLineII= findViewById(R.id.address2);
        city= findViewById(R.id.City);
        stateOrProvince= findViewById(R.id.StateOProvince);
        postalCode = findViewById(R.id.postalCode);
        country = findViewById(R.id.Country);
        email = findViewById(R.id.email);
        areaCode = findViewById(R.id.areaCode);
        phone= findViewById(R.id.phone);
        applyingJob = findViewById(R.id.applyingJob);
        startDate = findViewById(R.id.Fecha);
        fileName = findViewById(R.id.fileName);
        cancel = findViewById(R.id.cancel_action);

        firstName.setText(app.getFirstName());
        lastName.setText(app.getLastName());
        streetAddress.setText(app.getStreetAddress());
        streetAddressSecondLineII.setText(app.getStreetAddressSecondLineII());
        city.setText(app.getCity());
        stateOrProvince.setText(app.getStateOrProvince());
        String postal = String.valueOf(app.getPostalCode());
        postalCode.setText(postal);
        country.setText(app.getCountry());
        email.setText(app.getEmailAddress());
        String area = String.valueOf(app.getAreaCode());
        areaCode.setText(area);
        String numberPhone = String.valueOf(app.getPhoneNumber());
        phone.setText(numberPhone);
        applyingJob.setText(app.getApplyingJob());
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = format.format(app.getStartDate());
        startDate.setText(date);
        fileName.setText(app.getUploadFile());
    }
}
