package com.example.mana.worldcup18.data.database.history;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class History {
  @PrimaryKey(autoGenerate = true)
  private int id;
  private String location;
  private String winnerName;
  private int winnerFlag;
  private int winnerScore;
  private String runnerName;
  private int runnerFlag;
  private int runnerScore;
  private String thirdName;
  private int thirdFlag;
  private String finalStadium;
  private String topScorerName;
  private int topScorerFlag;
  private int topScorerGoals;
  private String bestPlayerName;
  private int bestPlayerFlag;
  private String goldenGloveName;
  private int goldenGloveFlag;
  private String cupRecaps;
  private boolean penalities;

  public History() {
  }

  public History(String location, String winnerName, int winnerFlag, int winnerScore,
      String runnerName, int runnerFlag, int runnerScore, String thirdName, int thirdFlag,
      String finalStadium, String topScorerName, int topScorerFlag, int topScorerGoals,
      String bestPlayerName,
      int bestPlayerFlag, String goldenGloveName, int goldenGloveFlag, String cupRecaps,
      boolean penalities) {
    this.location = location;
    this.winnerName = winnerName;
    this.winnerFlag = winnerFlag;
    this.winnerScore = winnerScore;
    this.runnerName = runnerName;
    this.runnerFlag = runnerFlag;
    this.runnerScore = runnerScore;
    this.thirdName = thirdName;
    this.thirdFlag = thirdFlag;
    this.finalStadium = finalStadium;
    this.topScorerName = topScorerName;
    this.topScorerFlag = topScorerFlag;
    this.bestPlayerName = bestPlayerName;
    this.bestPlayerFlag = bestPlayerFlag;
    this.goldenGloveName = goldenGloveName;
    this.topScorerGoals = topScorerGoals;
    this.goldenGloveFlag = goldenGloveFlag;
    this.cupRecaps = cupRecaps;
    this.penalities = penalities;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getWinnerName() {
    return winnerName;
  }

  public void setWinnerName(String winnerName) {
    this.winnerName = winnerName;
  }

  public int getWinnerFlag() {
    return winnerFlag;
  }

  public void setWinnerFlag(int winnerFlag) {
    this.winnerFlag = winnerFlag;
  }

  public int getWinnerScore() {
    return winnerScore;
  }

  public void setWinnerScore(int winnerScore) {
    this.winnerScore = winnerScore;
  }

  public String getRunnerName() {
    return runnerName;
  }

  public void setRunnerName(String runnerName) {
    this.runnerName = runnerName;
  }

  public int getRunnerFlag() {
    return runnerFlag;
  }

  public void setRunnerFlag(int runnerFlag) {
    this.runnerFlag = runnerFlag;
  }

  public int getRunnerScore() {
    return runnerScore;
  }

  public void setRunnerScore(int runnerScore) {
    this.runnerScore = runnerScore;
  }

  public String getThirdName() {
    return thirdName;
  }

  public void setThirdName(String thirdName) {
    this.thirdName = thirdName;
  }

  public int getThirdFlag() {
    return thirdFlag;
  }

  public void setThirdFlag(int thirdFlag) {
    this.thirdFlag = thirdFlag;
  }

  public String getFinalStadium() {
    return finalStadium;
  }

  public void setFinalStadium(String finalStadium) {
    this.finalStadium = finalStadium;
  }

  public String getTopScorerName() {
    return topScorerName;
  }

  public void setTopScorerName(String topScorerName) {
    this.topScorerName = topScorerName;
  }

  public int getTopScorerFlag() {
    return topScorerFlag;
  }

  public void setTopScorerFlag(int topScorerFlag) {
    this.topScorerFlag = topScorerFlag;
  }

  public String getBestPlayerName() {
    return bestPlayerName;
  }

  public void setBestPlayerName(String bestPlayerName) {
    this.bestPlayerName = bestPlayerName;
  }

  public int getBestPlayerFlag() {
    return bestPlayerFlag;
  }

  public void setBestPlayerFlag(int bestPlayerFlag) {
    this.bestPlayerFlag = bestPlayerFlag;
  }

  public String getGoldenGloveName() {
    return goldenGloveName;
  }

  public void setGoldenGloveName(String goldenGloveName) {
    this.goldenGloveName = goldenGloveName;
  }

  public int getGoldenGloveFlag() {
    return goldenGloveFlag;
  }

  public void setGoldenGloveFlag(int goldenGloveFlag) {
    this.goldenGloveFlag = goldenGloveFlag;
  }

  public String getCupRecaps() {
    return cupRecaps;
  }

  public void setCupRecaps(String cupRecaps) {
    this.cupRecaps = cupRecaps;
  }

  public int getTopScorerGoals() {
    return topScorerGoals;
  }

  public void setTopScorerGoals(int topScorerGoals) {
    this.topScorerGoals = topScorerGoals;
  }

  public boolean isPenalities() {
    return penalities;
  }

  public void setPenalities(boolean penalities) {
    this.penalities = penalities;
  }
}
