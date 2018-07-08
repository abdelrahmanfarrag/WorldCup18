package com.example.mana.worldcup18.data.database.knockout;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Knock {
  @PrimaryKey(autoGenerate = true)
  private int id;
  private String homeTeam;
  private int homeScore;
  private int homeFlag;
  private String awayTeam;
  private int awayScore;
  private int awayFlag;
  private String stadiumName;
  private String date;
  private String recaps;
  private int stadiumImg;
  private String round;
  String drawn;


  public Knock(String homeTeam, int homeScore, int homeFlag, String awayTeam, int awayScore,
      int awayFlag, String stadiumName, String date, String recaps, int stadiumImg,String round,String drawn) {
    this.homeTeam = homeTeam;
    this.homeScore = homeScore;
    this.homeFlag = homeFlag;
    this.awayTeam = awayTeam;
    this.awayScore = awayScore;
    this.awayFlag = awayFlag;
    this.stadiumName = stadiumName;
    this.date = date;
    this.recaps = recaps;
    this.stadiumImg = stadiumImg;
    this.round=round;
    this.drawn=drawn;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(String homeTeam) {
    this.homeTeam = homeTeam;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public void setHomeScore(int homeScore) {
    this.homeScore = homeScore;
  }

  public int getHomeFlag() {
    return homeFlag;
  }

  public void setHomeFlag(int homeFlag) {
    this.homeFlag = homeFlag;
  }

  public String getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(String awayTeam) {
    this.awayTeam = awayTeam;
  }

  public int getAwayScore() {
    return awayScore;
  }

  public void setAwayScore(int awayScore) {
    this.awayScore = awayScore;
  }

  public int getAwayFlag() {
    return awayFlag;
  }

  public void setAwayFlag(int awayFlag) {
    this.awayFlag = awayFlag;
  }

  public String getStadiumName() {
    return stadiumName;
  }

  public void setStadiumName(String stadiumName) {
    this.stadiumName = stadiumName;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getRecaps() {
    return recaps;
  }

  public void setRecaps(String recaps) {
    this.recaps = recaps;
  }

  public int getStadiumImg() {
    return stadiumImg;
  }

  public void setStadiumImg(int stadiumImg) {
    this.stadiumImg = stadiumImg;
  }

  public String getRound() {
    return round;
  }

  public void setRound(String round) {
    this.round = round;
  }

  public String getDrawn() {
    return drawn;
  }

  public void setDrawn(String drawn) {
    this.drawn = drawn;
  }
}
