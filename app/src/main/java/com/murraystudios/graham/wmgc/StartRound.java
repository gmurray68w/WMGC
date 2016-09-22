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
    int players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round);
        p1Name = (EditText) findViewById(R.id.etP1Name);
        p2Name = (EditText) findViewById(R.id.etP2Name);
        p3Name = (EditText) findViewById(R.id.etP3Name);
        p4Name = (EditText) findViewById(R.id.etP4Name);
        Button next = (Button) findViewById(R.id.btnNext);
        p2Name.setVisibility(View.GONE);
        p3Name.setVisibility(View.GONE);
        p4Name.setVisibility(View.GONE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adding player to List

                Intent i = new Intent(StartRound.this, ThreeHoleScoreSelection.class);

                if(players == 0){
                    players = 1;
                }
                if(players == 1){
                    player1N = p1Name.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("P1_KEY", player1N);
                    i.putExtras(bundle);

                }if (players == 2){
                    player1N = p1Name.getText().toString();
                    player2N = p2Name.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("P1_KEY", player1N);
                    bundle.putString("P2_KEY", player2N);
                    i.putExtras(bundle);

                }if(players == 3){
                    player1N = p1Name.getText().toString();
                    player2N = p2Name.getText().toString();
                    player3N = p3Name.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("P1_KEY", player1N);
                    bundle.putString("P2_KEY", player2N);
                    bundle.putString("P3_KEY", player3N);
                    i.putExtras(bundle);
                }if(players== 4){
                    player1N = p1Name.getText().toString();
                    player2N = p2Name.getText().toString();
                    player3N = p3Name.getText().toString();
                    player4N = p4Name.getText().toString();
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
                   players = 1;
                    p2Name.setVisibility(View.GONE);
                    p3Name.setVisibility(View.GONE);
                    p4Name.setVisibility(View.GONE);
                }
                if (checkedId == R.id.rb2Players) {
                    players = 2;
                    p2Name.setVisibility(View.VISIBLE);
                    p3Name.setVisibility(View.GONE);
                    p4Name.setVisibility(View.GONE);
                }
                if (checkedId == R.id.rb3Players) {
                     players = 3;
                    p2Name.setVisibility(View.VISIBLE);
                    p3Name.setVisibility(View.VISIBLE);
                    p4Name.setVisibility(View.GONE);
                }
                if (checkedId == R.id.rb4Players) {
                    players = 4;
                    p2Name.setVisibility(View.VISIBLE);
                    p3Name.setVisibility(View.VISIBLE);
                    p4Name.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
