package com.murraystudios.graham.wmgc;
/**
 * Created by Gmurray68w on 9/9/2016.
 */
public class PlayerList {
    /**
     * Name
     * phone
     * email
     * datePlayed, score, distancePlayed
     * putts
     * average
     */
    private String mName;
    private String mEmail;
    private String mPhone;
    private String mHole1;
    private String mHole2;
    private String mHole3;
    private String mHoleNumber;
    private String mScore;
    private String mPass;
    private String mP1H1;
    private String mP1H2;

    public PlayerList(String name, String holeNumber, String holeScore) {
        mName=name;
        mHoleNumber = holeNumber;
        mScore = holeScore;


    }

    public String getmName() {
        return mName;
    }
    public String getHoleInfo(){
        return mHoleNumber;
    }
    public String getmScore(){
        return  mScore;
    }
    public String getP1H1(){
        return mP1H1;
    }



}