package com.example.loginfromthebottom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

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
    ImageButton save;

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

        firstName= findViewById(R.id.fisrtName);
        lastName=  findViewById(R.id.lastName);
        streetAddress = findViewById(R.id.address1);
        streetAddressSecondLineII = findViewById(R.id.address2);
        city = findViewById(R.id.City);
        stateOrProvince = findViewById(R.id.StateOProvince);
        postalCode= findViewById(R.id.postalCode);
        country= findViewById(R.id.Country);
        email= findViewById(R.id.email);
        areaCode= findViewById(R.id.areaCode);
        phone= findViewById(R.id.phone);
        applyingJob = findViewById(R.id.applyingJob);
        startDate= findViewById(R.id.Fecha);
        uploadFile= findViewById(R.id.uploadFile);
        fileName = findViewById(R.id.fileName);
        save = findViewById(R.id.save);

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent file= new Intent(Intent.ACTION_GET_CONTENT);
                file.setType("*/*");
                startActivityForResult(file, 10);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empty()){

                }
            }
        });

    }

    private boolean empty() {
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    String name= path.substring(path.lastIndexOf("/")+1);
                    fileName.setText(path);
                }
                break;
        }
    }
}
