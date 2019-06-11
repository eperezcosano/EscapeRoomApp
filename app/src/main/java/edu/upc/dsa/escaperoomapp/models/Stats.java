package edu.upc.dsa.escaperoomapp.models;

import java.sql.Timestamp;

public class Stats {

    private int currentEnemiesKilled;
    private String currentTime;
    private int playedGames;
    private String currentWeapon;

    public Stats() {}

    public Stats(int currentEnemiesKilled, String currentTime, int playedGames, String currentWeapon) {
        this.currentEnemiesKilled = currentEnemiesKilled;
        this.currentTime = currentTime;
        this.playedGames = playedGames;
        this.currentWeapon = currentWeapon;
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

    @Override
    public String toString() {
        return "Stats{" +
                "currentEnemiesKilled=" + currentEnemiesKilled +
                ", currentTime='" + currentTime + '\'' +
                ", playedGames=" + playedGames +
                ", currentWeapon='" + currentWeapon + '\'' +
                '}';
    }
}
