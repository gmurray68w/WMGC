package com.murraystudios.graham.wmgc;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

import java.util.Calendar;

import static java.lang.String.valueOf;
/**
 * Created by Gmurray68w on 9/19/2016.
 */
public class TeeTimeFragment extends AppCompatActivity {
    RadioButton rbOne, rbTwo, rbThree, rbFour;
    private int mYear, mMonth, mDay, mHour, mMinute, playerQ;
    EditText txtDate, txtTime, pName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup);
        rbOne = (RadioButton)findViewById(R.id.rbOne);
        rbTwo = (RadioButton)findViewById(R.id.rbTwo);
        rbThree = (RadioButton)findViewById(R.id.rbThree);
        rbFour = (RadioButton)findViewById(R.id.rbFour);
        pName = (EditText) findViewById(R.id.etPartyName);
        Button setDate = (Button) findViewById(R.id.btnSetDate);
        txtDate = (EditText)findViewById(R.id.etDate);
        txtTime = (EditText)findViewById(R.id.etTime);


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(TeeTimeFragment.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtDate.setText( (monthOfYear + 1)+ "-" + dayOfMonth +  "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }

        });
        Button setTime = (Button)findViewById(R.id.btnSetTime);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(TeeTimeFragment.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }


            });
        Button save = (Button)findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = pName.getText().toString();
                String players = Integer.toString(playerQ);
                String date = txtDate.getText().toString();
                String time = txtTime.getText().toString();
                String reservation = name +" ," + players+ " ," + date + " ," + time;
                Intent i = new Intent(TeeTimeFragment.this, TeeTimes.class);
                Bundle bundle = new Bundle();
                bundle.putString("N_KEY", name);
                bundle.putString("P_KEY", players);
                bundle.putString("D_KEY", date);
                bundle.putString("T_KEY", time);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
    public void PlayerAmount(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.rbOne:
                if(checked)
                    rbTwo.setChecked(false);
                    rbThree.setChecked(false);
                    rbFour.setChecked(false);
                playerQ = 1;
                break;

            case R.id.rbTwo:
                if(checked)
                    rbOne.setChecked(false);
                rbThree.setChecked(false);
                rbFour.setChecked(false);
                    playerQ =2;
                    break;
            case R.id.rbThree:
                if(checked)
                    rbTwo.setChecked(false);
                rbOne.setChecked(false);
                rbFour.setChecked(false);
                    playerQ = 3;
                    break;
            case R.id.rbFour:
                if(checked)
                    rbTwo.setChecked(false);
                rbThree.setChecked(false);
                rbOne.setChecked(false);
                    playerQ =4;
                    break;


        }
    }
    public void show() {

        setContentView(R.layout.popup);
    }
}

