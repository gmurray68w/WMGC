package com.murraystudios.graham.wmgc;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
public class StartRound extends AppCompatActivity {
    EditText p1Name, p2Name, p3Name, p4Name;
    String player1N, player2N, player3N, player4N;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round);
        p1Name = (EditText) findViewById(R.id.etP1Name);
        p2Name = (EditText) findViewById(R.id.etP2Name);
        p3Name = (EditText) findViewById(R.id.etP3Name);
        p4Name = (EditText) findViewById(R.id.etP4Name);
        Button next = (Button) findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adding player to List

                player1N = p1Name.getText().toString();
                player2N = p2Name.getText().toString();
                player3N = p3Name.getText().toString();
                player4N = p4Name.getText().toString();

                Intent i = new Intent(StartRound.this, ThreeHoleScoreSelection.class);

                if(player2N == null && player3N == null && player4N == null){
                    Bundle bundle = new Bundle();
                    bundle.putString("P1_KEY", player1N);
                    i.putExtras(bundle);
                }

                if(player3N == null && player4N == null){
                    Bundle bundle = new Bundle();
                    bundle.putString("P1_KEY", player1N);
                    bundle.putString("P2_KEY", player2N);
                    i.putExtras(bundle);
                }
                if(player4N != null){
                    Bundle bundle = new Bundle();
                    bundle.putString("P1_KEY", player1N);
                    bundle.putString("P2_KEY", player2N);
                    bundle.putString("P3_KEY", player3N);
                    bundle.putString("P4_KEY", player4N);
                    i.putExtras(bundle);
                }
                startActivity(i);
            }
        });
        RadioGroup rgPlayerAmount = (RadioGroup) findViewById(R.id.rgPlayerAmount);
        rgPlayerAmount.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb1Player) {
                    //Keep state
                    int players = 1;
                }
                if (checkedId == R.id.rb2Players) {
                    int players = 2;
                }
                if (checkedId == R.id.rb3Players) {
                    int players = 3;
                }
                if (checkedId == R.id.rb4Players) {
                    int players = 4;
                }
            }
        });
    }
}
