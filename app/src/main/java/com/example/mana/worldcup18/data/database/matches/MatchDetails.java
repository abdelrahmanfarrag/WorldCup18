package com.example.mana.worldcup18.data.database.matches;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class MatchDetails {

  @PrimaryKey(autoGenerate = true)
  private int id;
  private int matchNumber, homeScore, homeFlag, awayScore, awayFlag;
  private String groupName;
  private String matchTime;
  private String stadiumName, homeTeam, awayTeam, recapId;

  public MatchDetails(int matchNumber, int homeScore, int homeFlag, int awayScore, int awayFlag,
      String groupName,
      String stadiumName, String homeTeam, String awayTeam, String matchTime, String recapId) {
    this.matchNumber = matchNumber;
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    this.groupName = groupName;
    this.stadiumName = stadiumName;
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.matchTime = matchTime;
    this.awayFlag = awayFlag;
    this.homeFlag = homeFlag;
    this.recapId = recapId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMatchNumber() {
    return matchNumber;
  }

  public void setMatchNumber(int matchNumber) {
    this.matchNumber = matchNumber;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public void setHomeScore(int homeScore) {
    this.homeScore = homeScore;
  }

  public int getAwayScore() {
    return awayScore;
  }

  public void setAwayScore(int awayScore) {
    this.awayScore = awayScore;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getStadiumName() {
    return stadiumName;
  }

  public void setStadiumName(String stadiumName) {
    this.stadiumName = stadiumName;
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(String homeTeam) {
    this.homeTeam = homeTeam;
  }

  public String getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(String awayTeam) {
    this.awayTeam = awayTeam;
  }

  public String getMatchTime() {
    return matchTime;
  }

  public void setMatchTime(String matchTime) {
    this.matchTime = matchTime;
  }

  public int getHomeFlag() {
    return homeFlag;
  }

  public void setHomeFlag(int homeFlag) {
    this.homeFlag = homeFlag;
  }

  public int getAwayFlag() {
    return awayFlag;
  }

  public void setAwayFlag(int awayFlag) {
    this.awayFlag = awayFlag;
  }

  public String getRecapId() {
    return recapId;
  }

  public void setRecapId(String recapId) {
    this.recapId = recapId;
  }
}

