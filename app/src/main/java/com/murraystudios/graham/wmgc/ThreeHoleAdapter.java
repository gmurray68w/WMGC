package com.murraystudios.graham.wmgc;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class ThreeHoleAdapter extends RecyclerView.Adapter<ThreeHoleAdapter.MyViewHolder>{
   private List<PlayerList> playerList;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvHole1, tvHole2, tvHole3, tvD1, tvD2, tvD3;

        public MyViewHolder(View view){
            super(view);
            context = view.getContext();
        }
    }
    public ThreeHoleAdapter( ArrayList<PlayerList> playerLists) {
        this.playerList = playerLists;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_hole_item, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        PlayerList playerInfo = playerList.get(position);
        holder.tvHole1.setText(playerInfo.getHoleInfo());


    }
    @Override
    public int getItemCount() {
        return playerList.size();

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_hole_item, parent, false);
        }


        //Player1 scores
        TextView p1h1 = (TextView)listItemView.findViewById(R.id.tvP1H1);
        TextView p1h2 = (TextView)listItemView.findViewById(R.id.tvP1H2);
        TextView p1h3 = (TextView)listItemView.findViewById(R.id.tvP1H3);

     //Player 2 Scores
        TextView  p2h1 = (TextView)listItemView.findViewById(R.id.tvP2H1);
        TextView p2h2 = (TextView)listItemView.findViewById(R.id.tvP2H2);
        TextView p2h3 = (TextView)listItemView.findViewById(R.id.tvP2H3);
        //P3 score
        TextView  p3h1 = (TextView)listItemView.findViewById(R.id.tvP3H1);
        TextView p3h2 = (TextView)listItemView.findViewById(R.id.tvP3H2);
        TextView p3h3 = (TextView)listItemView.findViewById(R.id.tvP3H3);
        //Player 4
        TextView  p4h1 = (TextView)listItemView.findViewById(R.id.tvP4H1);
        TextView p4h2 = (TextView)listItemView.findViewById(R.id.tvP4H2);
        TextView p4h3 = (TextView)listItemView.findViewById(R.id.tvP4H3);



        return listItemView;
    }
}
