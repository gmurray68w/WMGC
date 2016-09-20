package com.murraystudios.graham.wmgc;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Gmurray68w on 9/13/2016.
 */
public class StartRoundAdapter extends ArrayAdapter<PlayerList> {
    private List<PlayerList>playerList;

    public StartRoundAdapter(Context context, ArrayList<PlayerList> player) {
        super(context, 0, player);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.single_hole_item, parent, false);
        }
        PlayerList currentPlayer = getItem(position);
        //SetsPlayer1
        TextView name1 = (TextView)listItemView.findViewById(R.id.tvPlayer1Name);
        TextView name2 = (TextView)listItemView.findViewById(R.id.tvPlayer2Name);
        TextView name3 = (TextView)listItemView.findViewById(R.id.tvPlayer3Name);
        TextView name4 = (TextView)listItemView.findViewById(R.id.tvPlayer4Name);
        LinearLayout p1info = (LinearLayout)listItemView.findViewById(R.id.p1info);
        LinearLayout p2info = (LinearLayout)listItemView.findViewById(R.id.p2info);
        LinearLayout p3info = (LinearLayout)listItemView.findViewById(R.id.p3info);
        LinearLayout p4info = (LinearLayout)listItemView.findViewById(R.id.p4info);


        int playersAmount = getItemCount();
        if(playersAmount == 0){
            name1.setText(currentPlayer.getmName());
            p2info.setVisibility(View.GONE);
            p3info.setVisibility(View.GONE);
            p4info.setVisibility(View.GONE);
        }if(playersAmount == 1){
            name1.setText(currentPlayer.getmName());
            name2.setText(currentPlayer.getmName());
            p3info.setVisibility(View.GONE);
            p4info.setVisibility(View.GONE);
        }if(playersAmount ==2 ){
            name1.setText(currentPlayer.getmName());
            name2.setText(currentPlayer.getmName());
            name3.setText(currentPlayer.getmName());
            p4info.setVisibility(View.GONE);
        }if(playersAmount ==3){
            name1.setText(currentPlayer.getmName());
            name2.setText(currentPlayer.getmName());
            name3.setText(currentPlayer.getmName());
            name4.setText(currentPlayer.getmName());
        }




    return listItemView;
    }



    public int getItemCount(){return playerList.size(); }
}
