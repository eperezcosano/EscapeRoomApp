package edu.upc.dsa.escaperoomapp;

public class Username {
    private static Username instance;

    private String username;

    private Username() {
    }

    public static Username getInstance() {
        if (instance == null) instance = new Username();
        return instance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

}
