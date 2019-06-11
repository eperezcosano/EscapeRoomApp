package edu.upc.dsa.escaperoomapp.models;

public class ObjTo {

    private String nombre;

    public ObjTo() {}

    public ObjTo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ObjTo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
