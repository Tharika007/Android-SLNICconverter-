package com.example.slnicconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DateFormat;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Button EnterBtn, ClearBtn;
    TextView DisplayBirthday, DisplayGender, getIDTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterBtn = findViewById(R.id.ShowDetailsBtn);
        ClearBtn = findViewById(R.id.ClrBtn);

        DisplayBirthday = findViewById(R.id.DisplayBirthdayTxt);
        DisplayGender = findViewById(R.id.GenderTxt);
        getIDTxt = findViewById(R.id.GetIIDtxt);

        EnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //variables declaration
                String Year, Days;
                String birthday = "", birthmonth = "", dateofbirth, nextbirthday;
                int NIClength, DaysOfYear, intyear, remainingDays;
                int secdate = 0;

                //Get NIC from the user
                final String NICno = getIDTxt.getText().toString();

                //Length of NIC Number
                NIClength = NICno.length();

                //Extract year and date
                if (NIClength < 12) {
                    Year = "19" + NICno.substring(0, 2);
                    Days = NICno.substring(2, 3);
                } else {
                    Year = NICno.substring(0, 4);
                    Days = NICno.substring(4, 3);
                }

                //Convert string days to integer

                DaysOfYear = Integer.parseInt(Days);

                //checking gender
                if (DaysOfYear < 500) {
                    DisplayGender.setText("Male");
                } else {
                    DaysOfYear = DaysOfYear - 500;
                    DisplayGender.setText("Female");
                }

                if (DaysOfYear > 335) {
                    secdate = DaysOfYear - 335;
                    birthmonth = "December";
                } else if (DaysOfYear > 305) {
                    secdate = DaysOfYear - 305;
                    birthmonth = "November";
                } else if (DaysOfYear > 274) {
                    secdate = DaysOfYear - 274;
                    birthmonth = "October";
                } else if (DaysOfYear > 244) {
                    secdate = DaysOfYear - 244;
                    birthmonth = "September";
                } else if (DaysOfYear > 213) {
                    secdate = DaysOfYear - 213;
                    birthmonth = "August";
                } else if (DaysOfYear > 182) {
                    secdate = DaysOfYear - 182;
                    birthmonth = "July";
                } else if (DaysOfYear > 152) {
                    secdate = DaysOfYear - 152;
                    birthmonth = "June";
                } else if (DaysOfYear > 121) {
                    secdate = DaysOfYear - 121;
                    birthmonth = "May";
                } else if (DaysOfYear > 91) {
                    secdate = DaysOfYear - 91;
                    birthmonth = "April";
                } else if (DaysOfYear > 60) {
                    secdate = DaysOfYear - 60;
                    birthmonth = "March";
                } else if (DaysOfYear < 32) {
                    birthmonth = "January";
                    secdate = DaysOfYear;

                } else if (DaysOfYear > 31) {
                    secdate = DaysOfYear - 31;
                    birthmonth = "February";
                }


                String arr1 = new String(Year + birthmonth + secdate);
                DisplayBirthday.setText(arr1);


//                //convert string year to int year
//                intyear = Integer.parseInt(Year);
//
//                 int [] Monthdays = new int[12];
//                 int i = 0;
//
//                for ( i = 0; i < 12 ; i++) {
//                    Monthdays[i] = Date.Monthdays.append(str).(intyear, i + 1);
//
//
//                }
//
//                //calculate birth month
//
//                int j = 0;
//                for (j = 0; j < 12; j++) {
//                    DaysOfYear = DaysOfYear - Monthdays[j];
//                    if ( DaysOfYear < 0) {
//                        birthday = (DaysOfYear + Monthdays[j]).getText().toString();
//                        Monthdays = ( j + 1).toString();
//                        break;
//
//
//                    }




            }
        });


    }

}