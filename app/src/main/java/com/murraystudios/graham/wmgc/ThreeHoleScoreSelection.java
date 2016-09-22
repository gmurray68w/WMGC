package com.murraystudios.graham.wmgc;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class ThreeHoleScoreSelection extends AppCompatActivity {
    TextView strokeCounter;
    int strokes = 0;
    int holeDisplay = 0;
    int scorePostion, p1Strokes, p2Strokes, p3Strokes,p4Strokes, players;
    String currentStroke, p1, p2, p3, p4, holeNumber, parNumber, distanceNumber, p1N, p2N, p3N, p4N;
    TextView p1h1, p1h2, p1h3, p2h1, p2h2, p2h3, p3h1,p3h2,p3h3, p4h1, p4h2, p4h3, p1Total, p2Total, p3Total, p4Total, tvHole1Title,tvHole2Title,tvHole3Title,
    tvHole1Par, tvHole2Par, tvHole3Par, tvHole1Distance, tvHole2Distance, tvHole3Distance, player1Name, player2Name, player3Name, player4Name;
    List<HoleList> holes = new ArrayList<>();
    HoleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_hole_item);

        Bundle i = getIntent().getExtras();
        if (i != null) {
            p1N = i.getString("P1_KEY");
            p2N = i.getString("P2_KEY");
            p3N = i.getString("P3_KEY");
            p4N = i.getString("P4_KEY");
        }
        if(p1N != null && p2N == null){
            //ONE PLAYER
            LinearLayout p2Layout = (LinearLayout)findViewById(R.id.p2info);
            p2Layout.setVisibility(View.GONE);
            LinearLayout p3Layout = (LinearLayout)findViewById(R.id.p3info);
            p3Layout.setVisibility(View.GONE);
            LinearLayout p4Layout = (LinearLayout)findViewById(R.id.p4info);
            p4Layout.setVisibility(View.GONE);
            players = 1;
        }
        if(p2N != null && p3N == null ){
            //2 Players
            LinearLayout p3Layout = (LinearLayout)findViewById(R.id.p3info);
            p3Layout.setVisibility(View.GONE);
            LinearLayout p4Layout = (LinearLayout)findViewById(R.id.p4info);
            p4Layout.setVisibility(View.GONE);
            players = 2;
        }if(p3N != null && p4N == null){
            //3 players
            //TODO Hide layout 4

            LinearLayout p4Layout = (LinearLayout)findViewById(R.id.p4info);
            p4Layout.setVisibility(View.GONE);
            players = 3;
            //TODO

        }if(p4N != null){
            //4 Players are playing
            players =4;
            //TODO
        }


        //Create a random user so results are anonymous.


        RecyclerView myRv = (RecyclerView)findViewById(R.id.rvHoles);
        mAdapter = new HoleAdapter(holes);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRv.setLayoutManager(mLayoutManager);
        myRv.setItemAnimator(new DefaultItemAnimator());
        myRv.setAdapter(mAdapter);


        tvHole1Title = (TextView)findViewById(R.id.tvHoleOneTitle);
        tvHole2Title = (TextView)findViewById(R.id.tvHole2Title);
        tvHole3Title = (TextView)findViewById(R.id.tvHole3Title);
        tvHole1Par = (TextView)findViewById(R.id.tvParHole1);
        tvHole2Par = (TextView)findViewById(R.id.tvParHole2);
        tvHole3Par = (TextView)findViewById(R.id.tvParHole3);
        tvHole1Distance = (TextView)findViewById(R.id.tvHole1Distance) ;
        tvHole2Distance = (TextView)findViewById(R.id.tvHole2Distance);
        tvHole3Distance = (TextView)findViewById(R.id.tvHole3Distance);
        //Player1
        player1Name = (TextView)findViewById(R.id.tvPlayer1Name);
        player2Name = (TextView)findViewById(R.id.tvPlayer2Name);
        player3Name = (TextView)findViewById(R.id.tvPlayer3Name);
        player4Name = (TextView)findViewById(R.id.tvPlayer4Name);

        player1Name.setText(p1N);
        player2Name.setText(p2N);
        player3Name.setText(p3N);
        player4Name.setText(p4N);
        p1h1 = (TextView)findViewById(R.id.tvP1H1);
        p1h2 = (TextView) findViewById(R.id.tvP1H2);
        p1h3= (TextView) findViewById(R.id.tvP1H3);

        //Player 2 Scores
        p2h1 = (TextView)findViewById(R.id.tvP2H1);
        p2h2 = (TextView)findViewById(R.id.tvP2H2);
        p2h3 = (TextView)findViewById(R.id.tvP2H3);
        //P3 score
        p3h1 = (TextView)findViewById(R.id.tvP3H1);
        p3h2 = (TextView)findViewById(R.id.tvP3H2);
        p3h3 = (TextView)findViewById(R.id.tvP3H3);
        //Player 4
        p4h1 = (TextView)findViewById(R.id.tvP4H1);
        p4h2 = (TextView)findViewById(R.id.tvP4H2);
        p4h3 = (TextView)findViewById(R.id.tvP4H3);
        holeDisplay = 0;
        setDataSets();
        scorePostion = 0;
        TextBackgroundChange();
        ImageButton increaseStroke = (ImageButton)findViewById(R.id.ibIncreaseStroke);
        ImageButton decreaseStroke = (ImageButton)findViewById(R.id.ibDecreaseStrokes);

        ImageButton prevScore = (ImageButton)findViewById(R.id.ibPrevScore);
        Button addScore = (Button)findViewById(R.id.btnAddScore);
        strokeCounter = (TextView)findViewById(R.id.tvStrokeCounter);
        int p1Total = 0;

        String p2 = "" + p2Strokes;
        String p3 = "" + p3Strokes;
        String p4 = ""+ p4Strokes;
        HoleList hole0 = new HoleList("Hole #", "Par", "Distance", "17", p1N, p2N, p3N, p4N );
        holes.add(hole0);



        increaseStroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strokes++;
                currentStroke = strokes + "";
                strokeCounter.setText(currentStroke);

            }
        });
        decreaseStroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strokes--;
                currentStroke =strokes + "";
                strokeCounter.setText(currentStroke);
            }
        });

        prevScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToDo Add arraylist containing textviews


                //TODO CHANGE STROKE COUNTER TO WHAT IS RETURNED FROM GETCURRENTITEM

                scorePostion--;
                if(scorePostion >-1){
                    Toast.makeText(ThreeHoleScoreSelection.this, "Please choose a positive", Toast.LENGTH_LONG).show();
                    scorePostion = 0;
                }
                TextBackgroundChange();
            }
        });
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrentItem();
                //TODO SET CuRRENT Stroke to current focused item
                //Todo go to next item

                //Reset StrokeCounter

                TextChange();
                currentStroke = strokes +"";
                strokeCounter.setText(currentStroke);
                scorePostion++;
                TextBackgroundChange();
                /**
                if(players == 1){
                    TextChange();
                    currentStroke = strokes +"";
                    strokeCounter.setText(currentStroke);
                    scorePostion = scorePostion +4;
                    TextBackgroundChange();
                }if(players == 2){
                    TextChange();
                    currentStroke = strokes +"";
                    strokeCounter.setText(currentStroke);
                    scorePostion = scorePostion +3;
                    TextBackgroundChange();
                }if (scorePostion == 3){
                    TextChange();
                    currentStroke = strokes +"";
                    strokeCounter.setText(currentStroke);
                    scorePostion = scorePostion +2;
                    TextBackgroundChange();
                }if(players ==4) {
                    TextChange();
                    currentStroke = strokes +"";
                    strokeCounter.setText(currentStroke);
                    scorePostion++;
                    TextBackgroundChange();
                 }
                 **/




            }
        });


    }
    private void TextBackgroundChange() {
        if(scorePostion == 0){
            p4h3.setBackgroundColor(Color.TRANSPARENT);
            p1h1.setBackgroundColor(Color.YELLOW);
            p2h1.setBackgroundColor(Color.TRANSPARENT);

        }if(scorePostion == 1){
            p1h1.setBackgroundColor(Color.TRANSPARENT);
            p2h1.setBackgroundColor(Color.YELLOW);
            p3h1.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion == 2){
            p2h1.setBackgroundColor(Color.TRANSPARENT);
            p3h1.setBackgroundColor(Color.YELLOW);
            p4h1.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion == 3){
            p3h1.setBackgroundColor(Color.TRANSPARENT);
            p4h1.setBackgroundColor(Color.YELLOW);
            p1h2.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion == 4){
            p4h1.setBackgroundColor(Color.TRANSPARENT);
            p1h2.setBackgroundColor(Color.YELLOW);
            p2h2.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion == 5){
            p1h2.setBackgroundColor(Color.TRANSPARENT);
            p2h2.setBackgroundColor(Color.YELLOW);
            p3h2.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion ==6 ){
            p2h2.setBackgroundColor(Color.TRANSPARENT);
            p3h2.setBackgroundColor(Color.YELLOW);
            p4h2.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion ==7){
            p3h2.setBackgroundColor(Color.TRANSPARENT);
            p4h2.setBackgroundColor(Color.YELLOW);
            p1h1.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion ==8 ){
            p4h2.setBackgroundColor(Color.TRANSPARENT);
            p1h3.setBackgroundColor(Color.YELLOW);
            p2h3.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion ==9 ){
            p1h3.setBackgroundColor(Color.TRANSPARENT);
            p2h3.setBackgroundColor(Color.YELLOW);
            p3h3.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion ==10 ){
            p2h3.setBackgroundColor(Color.TRANSPARENT);
            p3h3.setBackgroundColor(Color.YELLOW);
            p4h3.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion ==11){
            p3h3.setBackgroundColor(Color.TRANSPARENT);
            p4h3.setBackgroundColor(Color.YELLOW);
            p4h2.setBackgroundColor(Color.TRANSPARENT);
        }if(scorePostion == 12){
            p4h3.setBackgroundColor(Color.TRANSPARENT);
            p1h1.setBackgroundColor(Color.YELLOW);
            p2h1.setBackgroundColor(Color.TRANSPARENT);
        }

    }

    private void TextChange() {
        if(scorePostion == 0){
            p1h1.setText(currentStroke);
            p1Strokes = strokes + p1Strokes;
            setFinalP1Score();

        }if(scorePostion == 1){
            p2h1.setText(currentStroke);
            p2Strokes = strokes + p2Strokes;
            setFinalP2Score();
        }if(scorePostion == 2) {
            p3h1.setText(currentStroke);
            p3Strokes = strokes + p3Strokes;
            setFinalP3Score();
        }if(scorePostion == 3){
            p4h1.setText(currentStroke);
            p4Strokes = strokes + p4Strokes;
            setFianlP4Score();
            save1HolesInfo();
        }if(scorePostion == 4){

            p1h2.setText(currentStroke);
            p1Strokes = strokes + p1Strokes;
            setFinalP1Score();
        }if(scorePostion == 5){
            p2h2.setText(currentStroke);
            p2Strokes = strokes + p2Strokes;
            setFinalP2Score();
        }if(scorePostion == 6){
            p3h2.setText(currentStroke);
            p3Strokes = strokes + p3Strokes;
            setFinalP3Score();
        }if(scorePostion == 7){
            p4h2.setText(currentStroke);
            p4Strokes = strokes+ p4Strokes;
            setFianlP4Score();
            save2HolesInfo();
        }if(scorePostion == 8){
            p1h3.setText(currentStroke);
            p1Strokes = strokes + p1Strokes;
            setFinalP1Score();

        }if(scorePostion == 9){
            p2h3.setText(currentStroke);
            p2Strokes = strokes + p2Strokes;
            setFinalP2Score();
        }if(scorePostion == 10){
            p3h3.setText(currentStroke);
            p3Strokes = strokes+ p3Strokes;
            setFinalP3Score();
        }if(scorePostion == 11){
            p4h3.setText(currentStroke);
            p4Strokes = strokes + p4Strokes;
            setFianlP4Score();
            save3HolesInfo();
        }if(scorePostion ==12){
            scorePostion = 0;

            resetHoles();
            holeDisplay ++;
            setDataSets();
            TextBackgroundChange();
            TextChange();
        }
    }
    private void resetHoles() {
        p1h1.setText("0");
        p2h1.setText("0");
        p3h1.setText("0");
        p4h1.setText("0");

        p1h2.setText("0");
        p2h2.setText("0");
        p3h2.setText("0");
        p4h2.setText("0");

        p1h3.setText("0");
        p2h3.setText("0");
        p3h3.setText("0");
        p4h3.setText("0");
    }
    private void save2HolesInfo() {
        String holeNumber = tvHole2Title.getText().toString();
        String parNumber = tvHole2Par.getText().toString();
        String distanceNumber = tvHole2Distance.getText().toString();
        p1 = p1h2.getText().toString();
        p2 = p2h2.getText().toString();
        p3 = p3h2.getText().toString();
        p4 = p4h2.getText().toString();
        HoleList hole2 = new HoleList(holeNumber, parNumber, distanceNumber, "17", p1, p2, p3, p4 );
        holes.add(hole2);
        mAdapter.notifyItemInserted(holes.size() -1);
    }
    private void save3HolesInfo() {
        String holeNumber = tvHole3Title.getText().toString();
        String parNumber = tvHole3Par.getText().toString();
        String distanceNumber = tvHole3Distance.getText().toString();
        p1 = p1h3.getText().toString();
        p2 = p2h3.getText().toString();
        p3 = p3h3.getText().toString();
        p4 = p4h3.getText().toString();
        HoleList hole3 = new HoleList(holeNumber, parNumber, distanceNumber, "17", p1, p2, p3, p4 );
        holes.add(hole3);
        mAdapter.notifyItemInserted(holes.size() -1);
    }
    private void setFianlP4Score() {
        p4Total = (TextView)findViewById(R.id.tvP4Total);
        p4Total.setText("" + p4Strokes);

    }
    private void save1HolesInfo() {

         holeNumber = tvHole1Title.getText().toString();
         parNumber = tvHole1Par.getText().toString();
         distanceNumber = tvHole1Distance.getText().toString();
         p1 = p1h1.getText().toString();
         p2 = p2h1.getText().toString();
         p3 = p3h1.getText().toString();
         p4 = p4h1.getText().toString();
        HoleList hole1 =new  HoleList(holeNumber, parNumber, distanceNumber, "17", p1, p2, p3, p4 );
        holes.add(hole1);
        mAdapter.notifyItemInserted(holes.size() -1);
    }
    private void setFinalP3Score() {
        p3Total = (TextView)findViewById(R.id.tvP3Total);

        p3Total.setText("" + p3Strokes);
    }
    private void setFinalP2Score() {
        p2Total = (TextView)findViewById(R.id.tvP2Total);
        p2Total.setText(""+ p2Strokes);
    }
    private void setFinalP1Score() {
        p1Total = (TextView)findViewById(R.id.tvP1Total);

        p1Total.setText(""+ p1Strokes);

    }
    private void setDataSets() {

        if(holeDisplay == 0){
            //Import first 3 holes
/**
            String holeNumber, String par, String handiCap, String blueDistance, String whiteDistance,
                    String redDistance, String goldDistance**/

        //Hole numbers
            tvHole1Title.setText("1");
            tvHole2Title.setText("2");
            tvHole3Title.setText("3");
        //Par Numbers

            tvHole1Par.setText("4");
            tvHole2Par.setText("4");
            tvHole3Par.setText("3");
            //Distance numbers
            tvHole1Distance.setText("301");
            tvHole2Distance.setText("276");
            tvHole3Distance.setText("133");
            //Handicap Numbers

            Toast.makeText(ThreeHoleScoreSelection.this, "ADDED HOLES SUCCESSFULLY 123" , Toast.LENGTH_SHORT).show();

        }if(holeDisplay == 1){
            //Import next 456
            //hole4
            tvHole1Title.setText("4");
            tvHole1Par.setText("5");
            tvHole1Distance.setText("527");
            //hole5
            tvHole2Title.setText("5");
            tvHole2Par.setText("4");
            tvHole1Distance.setText("260");
            //hole6
            tvHole3Title.setText("6");
            tvHole3Par.setText("4");
            tvHole3Distance.setText("321");

            Toast.makeText(ThreeHoleScoreSelection.this, "ADDED HOLES SUCCESSFULLY 456" , Toast.LENGTH_SHORT).show();
        }if(holeDisplay == 2){
            //Import 789
            tvHole1Title.setText("7");
            tvHole1Par.setText("3");
            tvHole1Distance.setText("181");
            //Hole 8
            tvHole2Title.setText("8");
            tvHole2Par.setText("5");
            tvHole2Distance.setText("518");
            //Hole 9
            tvHole3Title.setText("9");
            tvHole3Par.setText("4");
            tvHole3Distance.setText("336");

        }if(holeDisplay >2 ){
            //New round
            holeDisplay = 0;
            tvHole1Title.setText("1");
            tvHole2Title.setText("2");
            tvHole3Title.setText("3");
            //Par Numbers

            tvHole1Par.setText("4");
            tvHole2Par.setText("4");
            tvHole3Par.setText("3");
            //Distance numbers
            tvHole1Distance.setText("301");
            tvHole2Distance.setText("276");
            tvHole3Distance.setText("133");
            p1Strokes = 0;
            p2Strokes = 0;
            p3Strokes = 0;
            p4Strokes = 0;
        }
    }
    private void setCurrentItem() {


    }

}
