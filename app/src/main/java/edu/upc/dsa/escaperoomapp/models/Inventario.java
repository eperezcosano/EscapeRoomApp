package edu.upc.dsa.escaperoomapp.models;

import java.util.List;

public class Inventario {

    private List<Objetos> lista;
    private String userId;

    public Inventario() {}

    public Inventario(List<Objetos> lista, String userId) {
        this.lista = lista;
        this.userId = userId;
    }

    public List<Objetos> getLista() {
        return lista;
    }

    public void setLista(List<Objetos> lista) {
        this.lista = lista;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "lista=" + lista +
                ", userId='" + userId + '\'' +
                '}';
    }
}
