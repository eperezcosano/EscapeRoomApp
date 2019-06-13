package edu.upc.dsa.escaperoomapp.models;

public class Map {

    private int id;
    private String mapLevel;

    public Map() {}

    public Map(int id, String mapLevel) {
        this.id = id;
        this.mapLevel = mapLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMapLevel() {
        return mapLevel;
    }

    public void setMapLevel(String mapLevel) {
        this.mapLevel = mapLevel;
    }

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", mapLevel='" + mapLevel + '\'' +
                '}';
    }
}
