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
    EditText firstName;
    EditText lastName;
    EditText streetAddress;
    EditText streetAddressSecondLineII;
    EditText city;
    EditText stateOrProvince;
    EditText postalCode;
    EditText country;
    EditText email;
    EditText areaCode;
    EditText phone;
    EditText applyingJob;
    EditText startDate;
    TextView fileName;
    Database database = Database.getInstance();
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
        firstName.setEnabled(false);
        lastName.setText(app.getLastName());
        lastName.setEnabled(false);
        streetAddress.setText(app.getStreetAddress());
        streetAddress.setEnabled(false);
        streetAddressSecondLineII.setText(app.getStreetAddressSecondLineII());
        streetAddressSecondLineII.setEnabled(false);
        city.setText(app.getCity());
        city.setEnabled(false);
        stateOrProvince.setText(app.getStateOrProvince());
        stateOrProvince.setEnabled(false);
        String postal = String.valueOf(app.getPostalCode());
        postalCode.setText(postal);
        postalCode.setEnabled(false);
        country.setText(app.getCountry());
        country.setEnabled(false);
        email.setText(app.getEmailAddress());
        email.setEnabled(false);
        String area = String.valueOf(app.getAreaCode());
        areaCode.setText(area);
        areaCode.setEnabled(false);
        String numberPhone = String.valueOf(app.getPhoneNumber());
        phone.setText(numberPhone);
        phone.setEnabled(false);
        applyingJob.setText(app.getApplyingJob());
        applyingJob.setEnabled(false);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = format.format(app.getStartDate());
        startDate.setText(date);
        startDate.setEnabled(false);
        fileName.setText(app.getUploadFile());
    }
}
