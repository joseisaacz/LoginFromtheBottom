package com.example.loginfromthebottom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginfromthebottom.Data.Database;
import com.example.loginfromthebottom.Model.JobApplicationModel;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JobApplication extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText streetAddress;
    EditText streetAddressSecondLineII;
    EditText city;
    EditText stateOrProvince;
    EditText postalCode;
    Spinner country;
    EditText email;
    EditText areaCode;
    EditText phone;
    Spinner applyingJob;
    EditText startDate;
    ImageButton uploadFile;
    TextView fileName;
    Database database = Database.getInstance();
    ImageButton save;
    ImageButton cancel;
private final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_application);
        final EditText fechaFld = (EditText) findViewById(R.id.Fecha);
        final DatePickerDialog[] datePickerDialog = new DatePickerDialog[1];

        fechaFld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog[0] = new DatePickerDialog(JobApplication.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                fechaFld.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog[0].show();
            }
        });

        String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
                "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
                "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
                "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
                "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
                "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
                "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
                "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
                "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
                "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
                "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
                "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
                "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
                "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
                "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
                "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
                "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
                "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
                "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
                "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
                "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands",
                "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
                "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
                "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
                "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
                "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
                "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon",
                "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
                "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga",
                "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
                "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
                "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
                "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
        Spinner s = (Spinner) findViewById(R.id.Country);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        firstName = findViewById(R.id.fisrtName);
        lastName = findViewById(R.id.lastName);
        streetAddress = findViewById(R.id.address1);
        streetAddressSecondLineII = findViewById(R.id.address2);
        city = findViewById(R.id.City);
        stateOrProvince = findViewById(R.id.StateOProvince);
        postalCode = findViewById(R.id.postalCode);
        country = findViewById(R.id.Country);
        email = findViewById(R.id.email);
        areaCode = findViewById(R.id.areaCode);
        phone = findViewById(R.id.phone);
        applyingJob = findViewById(R.id.applyingJob);
        startDate = findViewById(R.id.Fecha);
        uploadFile = findViewById(R.id.uploadFile);
        fileName = findViewById(R.id.fileName);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel_action);

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent file = new Intent(Intent.ACTION_GET_CONTENT);
                file.setType("*/*");
                startActivityForResult(file, 10);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    submitForm();
                } else {
                    Toast.makeText(getApplicationContext(), "There is Empty fields in the form", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAction();
            }
        });

    }

    private void cancelAction() {
        firstName.setText("");
        lastName.setText("");
        streetAddress.setText("");
        streetAddressSecondLineII.setText("");
        city.setText("");
        areaCode.setText("");
        phone.setText("");
        postalCode.setText("");
        email.setText("");
        startDate.setText("");
        stateOrProvince.setText("");
        Intent nav = new Intent(getApplicationContext(), NavDrawerActivity.class);
        startActivity(nav);
        finish();
    }

    private boolean validar() {
        if(!(email.getText().toString().trim().matches(EMAIL_PATTERN))){
            email.setError("Invalid email address");
            return false;
        }else if (String.valueOf(firstName.getText()).isEmpty()) {
            firstName.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(lastName.getText()).isEmpty()) {
            lastName.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(streetAddress.getText()).isEmpty()) {
            streetAddress.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(streetAddressSecondLineII.getText()).isEmpty()) {
            streetAddressSecondLineII.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(city.getText()).isEmpty()) {
            city.setError("This filed cannot be blank");
            return false;
        } else if (String.valueOf(stateOrProvince.getText()).isEmpty()) {
            stateOrProvince.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(postalCode.getText()).isEmpty()) {
            postalCode.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(email.getText()).isEmpty()) {
            email.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(areaCode.getText()).isEmpty()) {
            areaCode.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(phone.getText()).isEmpty()) {
            phone.setError("This field cannot be blank");
            return false;
        } else if (String.valueOf(startDate.getText()).isEmpty()) {
            startDate.setError("This field cannot be blank");
            return false;
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    String name = path.substring(path.lastIndexOf("/") + 1);
                    fileName.setText(path);
                }
                break;
        }
    }


    private void submitForm() {
        try {
            String name = firstName.getText().toString();
            String lastNameTxt = lastName.getText().toString();
            String streetLine = streetAddress.getText().toString();
            String streetLine2 = streetAddressSecondLineII.getText().toString();
            String cityTxt = city.getText().toString();
            String state = stateOrProvince.getText().toString();
            int postal = Integer.parseInt(postalCode.getText().toString());
            String countryTxt = (String) country.getSelectedItem();
            String emailTxt = email.getText().toString();
            String areaCodeTxt = areaCode.getText().toString();
            String phoneTxt = phone.getText().toString();
            String position = (String) applyingJob.getSelectedItem();
            String dateStr = startDate.getText().toString();
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(dateStr);
            String file = fileName.getText().toString();
            JobApplicationModel jobApp = new JobApplicationModel(Database.idJobApp++, name, lastNameTxt, streetLine, streetLine2, cityTxt, state, postal, countryTxt,
                    emailTxt, areaCodeTxt, phoneTxt, position, date, file);

            Database.getListOfApplications().add(jobApp);
            Toast.makeText(getApplicationContext(), "Informacion Guardada", Toast.LENGTH_LONG).show();
            for (JobApplicationModel job : Database.getListOfApplications()) {
                Log.v("JOB APP", job.toString());
            }
            Intent nav = new Intent(getApplicationContext(), NavDrawerActivity.class);
            startActivity(nav);
            finish();


        } catch (Exception e) {

            e.printStackTrace();
            Log.e("SUBMIT ERROR", e.getMessage());
        }


    }


    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, NavDrawerActivity.class));
        super.onBackPressed();
    }
}
