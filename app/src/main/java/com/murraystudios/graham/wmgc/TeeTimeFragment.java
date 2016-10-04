package com.murraystudios.graham.wmgc;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static java.lang.String.valueOf;
/**
 * Created by Gmurray68w on 9/19/2016.
 */
public class TeeTimeFragment extends Fragment {
    RadioButton rbOne, rbTwo, rbThree, rbFour;
    private int mYear, mMonth, mDay, mHour, mMinute, playerQ;
    EditText txtDate, txtTime, pName;
    String players;
    public TeeTimeFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.popup, container);

        rbOne = (RadioButton)view.findViewById(R.id.rbOne);
        rbTwo = (RadioButton)view.findViewById(R.id.rbTwo);
        rbThree = (RadioButton)view.findViewById(R.id.rbThree);
        rbFour = (RadioButton)view.findViewById(R.id.rbFour);
        pName = (EditText) view.findViewById(R.id.etPartyName);
        Button setDate = (Button)view.findViewById(R.id.btnSetDate);
        txtDate = (EditText)view.findViewById(R.id.etDate);
        txtTime = (EditText)view.findViewById(R.id.etTime);


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
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
        Button setTime = (Button)view.findViewById(R.id.btnSetTime);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
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
        Button save = (Button)view.findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = pName.getText().toString();
               players = "" + playerQ;
                String date = txtDate.getText().toString();
                String time = txtTime.getText().toString();
                String reservation = name +" = SET NAME ," + players+ "= PLAYERS ," + date + " ," + time;
                Intent i = new Intent(getContext(), TeeTimes.class);
                Bundle bundle = new Bundle();
                bundle.putString("N_KEY", name);
                bundle.putString("P_KEY", players);
                bundle.putString("D_KEY", date);
                bundle.putString("T_KEY", time);
                i.putExtras(bundle);
                Toast.makeText(getContext(), "" + reservation, Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        return view;
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
                Toast.makeText(getContext(), "" + playerQ, Toast.LENGTH_SHORT).show();

                break;

            case R.id.rbTwo:
                if(checked)
                    rbOne.setChecked(false);
                rbThree.setChecked(false);
                rbFour.setChecked(false);
                    playerQ =2;
                Toast.makeText(getContext(), "" + playerQ, Toast.LENGTH_SHORT).show();
                    break;
            case R.id.rbThree:
                if(checked)
                    rbTwo.setChecked(false);
                rbOne.setChecked(false);
                rbFour.setChecked(false);
                playerQ = 3;
                Toast.makeText(getContext(), "" + playerQ, Toast.LENGTH_SHORT).show();
                    break;
            case R.id.rbFour:
                if(checked)
                    rbTwo.setChecked(false);
                rbThree.setChecked(false);
                rbOne.setChecked(false);
                    playerQ =4;
                Toast.makeText(getContext(), "" + playerQ, Toast.LENGTH_SHORT).show();
                    break;


        }
    }
    public void show() {


    }
}

