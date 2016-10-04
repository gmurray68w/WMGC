package com.murraystudios.graham.wmgc;
/**
 * Created by Gmurray68w on 9/18/2016.
 */
public class TeeTimesList {
    private String mDate;
    private String mPartyName;
    private String mPartyAmount;
    private String mTime;


    public TeeTimesList(String partyName,String partyAmount ,String date, String time){

        mPartyName = partyName;
        mPartyAmount = partyAmount;
        mDate = date;
        mTime = time;

    }
    public String getmPartyName() {
        return mPartyName;
    }
    public String getmPartyAmount(){
        return mPartyAmount;
    }
    public String getmTime() {
        return mTime;
    }
    public String getmDate() {
        return mDate;
    }


}
