package com.murraystudios.graham.wmgc;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
/**
 * Created by Gmurray68w on 9/9/2016.
 */
public class HoleAdapter extends RecyclerView.Adapter<HoleAdapter.MyViewHolder2> {
    private List<HoleList> hList;
    private Context context;
    TextView tvHole1, tvHole2, tvHole3, tvD3, tvD2, tvD1, parH1, parH2, parH3, hand, p1Info, p2Info, p3Info, p4Info;
    public HoleAdapter(List<HoleList> holes) {
        this.hList = holes;
    }
    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        public MyViewHolder2 (View view2 ){
            super(view2);

            tvHole1 = (TextView)view2.findViewById(R.id.tvHoleTitle);
             tvD1 = (TextView)view2.findViewById(R.id.tvTeeLabel);
             parH1= (TextView)view2.findViewById(R.id.tvParTitle);
            hand = (TextView)view2.findViewById(R.id.tvHandicapTitle);
            p1Info = (TextView)view2.findViewById(R.id.tvPlayer1Scores);
            p2Info = (TextView)view2.findViewById(R.id.tvPlayer2Scores);
            p3Info = (TextView)view2.findViewById(R.id.tvPlayer3Scores);
            p4Info = (TextView)view2.findViewById(R.id.tvPlayer4Scores);



        }
    }

    @Override
    public HoleAdapter.MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holes_three, parent, false);
        return new MyViewHolder2(itemView);
    }
    @Override
    public void onBindViewHolder(HoleAdapter.MyViewHolder2 holder, int position) {
        HoleList currentHole = hList.get(position);

        tvHole1.setText(currentHole.getmHoleNumber());
        parH1.setText(currentHole.getmPar());
        tvD1.setText(currentHole.getmBlueDistance());
        hand.setText(currentHole.getmHandiCap());
        p1Info.setText(currentHole.getMPlayer1Score());
        p2Info.setText(currentHole.getmPlayer2Score());
        p3Info.setText(currentHole.getmPlayer3Score());
        p4Info.setText(currentHole.getmPlayer4Score());
    }
    @Override
    public int getItemCount() {
        return hList.size();
    }
}

