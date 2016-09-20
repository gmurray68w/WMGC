package com.murraystudios.graham.wmgc;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
/**
 * Created by Gmurray68w on 9/18/2016.
 */
public class TeeTimesAdapter extends RecyclerView.Adapter<TeeTimesAdapter.MyViewHolder3> {
    private List<TeeTimesList> tList;
    TextView ttDate, ttTime, ttName, ttPlayers;
    public TeeTimesAdapter(List<TeeTimesList> teeTime) {
        this.tList = teeTime;
    }
    public class MyViewHolder3 extends RecyclerView.ViewHolder {
        public MyViewHolder3 (View view2 ) {
            super(view2);
            ttName = (TextView)view2.findViewById(R.id.tvPartyName);
            ttPlayers= (TextView)view2.findViewById(R.id.tvPartyAmt);
            ttDate =  (TextView)view2.findViewById(R.id.tvDate);
            ttTime= (TextView)view2.findViewById(R.id.tvTime);

        }
        }
    @Override
    public TeeTimesAdapter.MyViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_tee_time, parent, false);
        return new TeeTimesAdapter.MyViewHolder3(itemView);
    }
    @Override
    public void onBindViewHolder(TeeTimesAdapter.MyViewHolder3 holder, int position) {
        TeeTimesList teeList = tList.get(position);
        ttName.setText(teeList.getmPartyName());
        ttPlayers.setText(teeList.getmPartyAmount());
        ttDate.setText(teeList.getmDate());
        ttTime.setText(teeList.getmTime());

    }
    @Override
    public int getItemCount() {
        return tList.size();
    }
}
