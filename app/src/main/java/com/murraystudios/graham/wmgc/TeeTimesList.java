package com.murraystudios.graham.wmgc;
/**
 * Created by Gmurray68w on 9/18/2016.
 */
public class TeeTimesList {
    private String mDate;
    private String mPartyName;
    private String mPartyAmount;
    private String mTime;
    private String mCheckedIn;

    public TeeTimesList(String partyName,String partyAmount ,String date, String time){
        this.mDate = date;
        this.mTime = time;
        this.mPartyName = partyName;
        this.mPartyAmount = partyAmount;

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
