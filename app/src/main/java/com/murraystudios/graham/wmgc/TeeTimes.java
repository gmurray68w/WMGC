package com.murraystudios.graham.wmgc;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.security.AccessController.getContext;
public class TeeTimes extends AppCompatActivity{

    RadioButton rbOne, rbTwo, rbThree, rbFour;
    private int mYear, mMonth, mDay, mHour, mMinute, playerQ;
    EditText txtDate, txtTime, pName;
    List<TeeTimesList> teeTime = new ArrayList<>();
    private TeeTimesAdapter mAdapter;
    private CheckBox tvCheckin;
    private String name, players, date, time;
    int position = 0;
    TeeTimesList t1;
    TeeTimeFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tee_times);

        rbOne = (RadioButton)findViewById(R.id.rbOne);
        rbTwo = (RadioButton)findViewById(R.id.rbTwo);
        rbThree = (RadioButton)findViewById(R.id.rbThree);
        rbFour = (RadioButton)findViewById(R.id.rbFour);
        pName = (EditText) findViewById(R.id.etPartyName);
        Button setDate = (Button)findViewById(R.id.btnSetDate);
        txtDate = (EditText)findViewById(R.id.etDate);
        txtTime = (EditText)findViewById(R.id.etTime);

        rbOne.setChecked(true);


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(TeeTimes.this,
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
                TimePickerDialog timePickerDialog = new TimePickerDialog(TeeTimes.this,
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
                players = "" + playerQ;
                String date = txtDate.getText().toString();
                String time = txtTime.getText().toString();
                String reservation = name +" = SET NAME ," + players+ "= PLAYERS ," + date + " ," + time;

                AddReservation(name, players, date, time);

            }
        });

        RecyclerView myRv = (RecyclerView) findViewById(R.id.rvTeeTimes);
        mAdapter = new TeeTimesAdapter(teeTime);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myRv.setLayoutManager(mLayoutManager);
        myRv.setItemAnimator(new DefaultItemAnimator());
        myRv.setAdapter(mAdapter);





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
                Toast.makeText(getApplicationContext(), "" + playerQ, Toast.LENGTH_SHORT).show();

                break;

            case R.id.rbTwo:
                if(checked)
                    rbOne.setChecked(false);
                rbThree.setChecked(false);
                rbFour.setChecked(false);
                playerQ =2;
                Toast.makeText(getApplicationContext(), "" + playerQ, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbThree:
                if(checked)
                    rbTwo.setChecked(false);
                rbOne.setChecked(false);
                rbFour.setChecked(false);
                playerQ = 3;
                Toast.makeText(getApplicationContext(), "" + playerQ, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbFour:
                if(checked)
                    rbTwo.setChecked(false);
                rbThree.setChecked(false);
                rbOne.setChecked(false);
                playerQ =4;
                Toast.makeText(getApplicationContext(), "" + playerQ, Toast.LENGTH_SHORT).show();
                break;


        }
    }
    private void AddReservation( String name, String date, String time, String players) {
        position++;
        if(position >4){
            Toast.makeText(TeeTimes.this, "Only able to reserve 4 times at once. ", Toast.LENGTH_SHORT).show();
            return;
        }else {
            if(name.equals("")){
                Toast.makeText(TeeTimes.this, "Please enter your party name. ", Toast.LENGTH_SHORT).show();
                return;
            } if(date.equals("")){
                Toast.makeText(TeeTimes.this, "Please enter a reservation date. ", Toast.LENGTH_SHORT).show();
                return;
            } if(time.equals("")){
                Toast.makeText(TeeTimes.this, "Please enter a reservation time. ", Toast.LENGTH_SHORT).show();
                return;
            }else {
                t1 = new TeeTimesList(name, players, date, time);
                teeTime.add(t1);
                mAdapter.notifyItemInserted(position);
            }
        }

            /**
             * TODO Send to firebase
             * TODO Check in button to send and remove from recyclerview
             */


    }
    @Override
    protected void onPostResume() {
        Bundle i = getIntent().getExtras();
        if (i != null) {

            name =  i.getString("N_KEY");
            players = i.getString("P_KEY");
            date = i.getString("D_KEY");
            time = i.getString("T_KEY");

            AddReservation( name, date, time, players);
        }
        super.onPostResume();
    }
}






