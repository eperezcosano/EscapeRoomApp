package edu.upc.dsa.escaperoomapp.models;

public class Objetos {

    private int id;
    private String type;
    private String name;
    private String cost;
    private String atribute;
    private String amount;

    public Objetos() {}

    public Objetos(int id, String type, String name, String cost, String atribute, String amount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.atribute = atribute;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAtribute() {
        return atribute;
    }

    public void setAtribute(String atribute) {
        this.atribute = atribute;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Objetos{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", atribute='" + atribute + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
