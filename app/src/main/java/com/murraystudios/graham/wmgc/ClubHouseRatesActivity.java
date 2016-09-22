package com.murraystudios.graham.wmgc;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
public class ClubHouseRatesActivity extends AppCompatActivity {
    TextView wkdJR18, wkdJR9, wkdSr18, wkdSr9, wkdReg18, wkdReg9, wkeJR18, wkeJR9, wkeSr18, wkeSr9, wkeReg18, wkeReg9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rates_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarRates);

        setSupportActionBar(toolbar);
        //WeekDAY
        wkdJR18 = (TextView)findViewById(R.id.tvWkdJr18);
        wkdJR9 = (TextView)findViewById(R.id.tvWkdJr9);
        wkdSr18 = (TextView)findViewById(R.id.tvWkdSr18);
        wkdSr9 = (TextView)findViewById(R.id.tvWkdSr9);
        wkdReg18= (TextView)findViewById(R.id.tvWkdReg18);
        wkdReg9 = (TextView)findViewById(R.id.tvWkdReg9);

        //Weekend
        wkeJR18 = (TextView)findViewById(R.id.tvWkeJr18);
        wkeJR9 = (TextView)findViewById(R.id.tvWkeJr9);
        wkeSr18 = (TextView)findViewById(R.id.tvWkeSr18);
        wkeSr9 = (TextView)findViewById(R.id.tvWkeSr9);
        wkeReg18= (TextView)findViewById(R.id.tvWkeReg18);
        wkeReg9 = (TextView)findViewById(R.id.tvWkeReg9);
        final CheckBox addCart = (CheckBox)findViewById(R.id.cbAddCart);
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = addCart.isChecked();
               if(checked){
                   //With Cart
                        //Weekday
                   wkdJR18.setText("$20");
                   wkdJR9.setText("$14");
                   wkdSr18.setText("$24");
                   wkdSr9.setText("$11");
                   wkdReg18.setText("$25");
                   wkdReg9.setText("$18");
                        //Weekend
                   wkeJR18.setText("$22");
                   wkeJR9.setText("$16");
                   wkeSr18.setText("$29");
                   wkeSr9.setText("$22");
                   wkeReg18.setText("$29");
                   wkeReg9.setText("$22");
               }else {
                   //Without Cart
                   wkdJR18.setText("$10");
                   wkdJR9.setText("$8  ");
                   wkdSr18.setText("$19");
                   wkdSr9.setText("$24");
                   wkdReg18.setText("$15");
                   wkdReg9.setText("$12");

                   wkeJR18.setText("$12");
                   wkeJR9.setText("$10");
                   wkeSr18.setText("$19");
                   wkeSr9.setText("$16");
                   wkeReg18.setText("$19");
                   wkeReg9.setText("$16");
               }
            }
        });

    }
}
