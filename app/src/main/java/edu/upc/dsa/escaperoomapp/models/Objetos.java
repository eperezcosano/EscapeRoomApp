package edu.upc.dsa.escaperoomapp.models;

public class Objetos {

    private Integer id;
    private String type;
    private String nombre;
    private Integer coste;
    private String atributo;
    private Integer amount;

    public Objetos() {}

    public Objetos(Integer id, String type, String nombre, Integer coste, String atributo, Integer amount) {
        this.id = id;
        this.type = type;
        this.nombre = nombre;
        this.coste = coste;
        this.atributo = atributo;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Objetos{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", nombre='" + nombre + '\'' +
                ", coste=" + coste +
                ", atributo='" + atributo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
