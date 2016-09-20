package com.murraystudios.graham.wmgc;
/**
 * Created by Gmurray68w on 9/9/2016.
 */
public class HoleList {
    /**
     * HoleNmber
     * Par
     * HandiCap
     * BlueDistance
     * BlackDistance
     * WhiteDistance
     * RedDistance
     * GoldDistance
     */
    private String mHoleNumber;
    private String mPar;
    private String mHandiCap;
    private String mBlueDistance;
    private String mPlayer1Score;
    private String mPlayer2Score;
    private String mPlayer3Score;
    private String mPlayer4Score;
    private int score;
    public HoleList(String holeNumber, String par, String blueDistance ,String handiCap, String p1Score, String p2Score,
                    String p3Score, String p4Score) {
        mHoleNumber = holeNumber;
        mPar = par;
        mBlueDistance = blueDistance;
        mHandiCap = handiCap;
        mPlayer1Score = p1Score;
        mPlayer2Score = p2Score;
        mPlayer3Score = p3Score;
        mPlayer4Score = p4Score;
    }
    public String getmHoleNumber() {
        return mHoleNumber;
    }
    public String getmPar() {
        return mPar;
    }
    public String getmHandiCap() {
        return mHandiCap;
    }
    public String getmBlueDistance() {
        return mBlueDistance;
    }
    public String getMPlayer1Score() {return  mPlayer1Score;}
    public String getmPlayer2Score(){
        return mPlayer2Score;
    }
    public String getmPlayer3Score(){
        return mPlayer3Score;
    }
    public String getmPlayer4Score(){
        return mPlayer4Score;
    }
    public int getScore() {
        return score;
    }
}
