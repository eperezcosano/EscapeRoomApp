package edu.upc.dsa.escaperoomapp.models;

import java.util.List;

public class Inventario {

    private String username;
    private List<Objetos> lista;

    public Inventario() {}

    public Inventario(String username, List<Objetos> lista) {
        this.username = username;
        this.lista = lista;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Objetos> getLista() {
        return lista;
    }

    public void setLista(List<Objetos> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "username='" + username + '\'' +
                ", lista=" + lista +
                '}';
    }
}
