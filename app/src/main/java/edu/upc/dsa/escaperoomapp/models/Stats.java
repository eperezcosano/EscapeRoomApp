package edu.upc.dsa.escaperoomapp.models;

public class Stats {

    private int currentEnemiesKilled;
    private String currentTime;
    private String recordTime;
    private int playedGames;
    private String currentWeapon;
    private String currentShield;
    private int currentLife;
    private int currentLevel;
    private int cash;

    public Stats() {}

    public Stats(int currentEnemiesKilled, String currentTime, String recordTime, int playedGames, String currentWeapon, String currentShield, int currentLife, int currentLevel, int cash) {
        this.currentEnemiesKilled = currentEnemiesKilled;
        this.currentTime = currentTime;
        this.recordTime = recordTime;
        this.playedGames = playedGames;
        this.currentWeapon = currentWeapon;
        this.currentShield = currentShield;
        this.currentLife = currentLife;
        this.currentLevel = currentLevel;
        this.cash = cash;
    }

    public int getCurrentEnemiesKilled() {
        return currentEnemiesKilled;
    }

    public void setCurrentEnemiesKilled(int currentEnemiesKilled) {
        this.currentEnemiesKilled = currentEnemiesKilled;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public String getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(String currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public String getCurrentShield() {
        return currentShield;
    }

    public void setCurrentShield(String currentShield) {
        this.currentShield = currentShield;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "currentEnemiesKilled=" + currentEnemiesKilled +
                ", currentTime='" + currentTime + '\'' +
                ", recordTime='" + recordTime + '\'' +
                ", playedGames=" + playedGames +
                ", currentWeapon='" + currentWeapon + '\'' +
                ", currentShield='" + currentShield + '\'' +
                ", currentLife=" + currentLife +
                ", currentLevel=" + currentLevel +
                ", cash=" + cash +
                '}';
    }
}
