package com.murraystudios.graham.wmgc;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.List;
public class TeeTimes extends AppCompatActivity{
    List<TeeTimesList> teeTime = new ArrayList<>();
    TeeTimesAdapter mAdapter;
    private Button add;
    private String name, players, date, time;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tee_times);

        Bundle i = getIntent().getExtras();
        if (i != null) {

            name =  i.getString("N_KEY");
            players = i.getString("P_KEY");
            date = i.getString("D_KEY");
            time = i.getString("T_KEY");
            position = position +1;
            AddReservation(position, name, date, time, players);
        }

        RecyclerView myRv = (RecyclerView) findViewById(R.id.rvTeeTimes);
        mAdapter = new TeeTimesAdapter(teeTime);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRv.setLayoutManager(mLayoutManager);
        myRv.setItemAnimator(new DefaultItemAnimator());
        myRv.setAdapter(mAdapter);
        add = (Button) findViewById(R.id.btnAddTT);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(TeeTimes.this, TeeTimeFragment.class);
                startActivity(i);

            }
        });
    }
    private void AddReservation(int position, String name, String date, String time, String players) {

        TeeTimesList t1 = new TeeTimesList(name, players, date, time);
        teeTime.add(t1);


    }
}






