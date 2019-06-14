package edu.upc.dsa.escaperoomapp;

import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.escaperoomapp.models.Inventario;
import edu.upc.dsa.escaperoomapp.models.Map;
import edu.upc.dsa.escaperoomapp.models.Objetos;
import edu.upc.dsa.escaperoomapp.models.Stats;

public class ApiUnity {


    public static void sendStats(String stringStats)
    {
        Stats stats = new Stats();
        String[] trozos = stringStats.split(",");
        stats.setCurrentLevel(Integer.parseInt(trozos[0]));
        stats.setCash(Integer.parseInt(trozos[1]));
        stats.setCurrentTime(trozos[2]);
        stats.setCurrentEnemiesKilled(Integer.parseInt(trozos[3]));
        stats.setCurrentLife(Integer.parseInt(trozos[4]));
        stats.setCurrentWeapon(trozos[5]);
        stats.setCurrentShield(trozos[6]);

        Singleton.getInstance().setStats(stats);
        Singleton.getInstance().sendStats();

    }

    public static String getPlayerStats() {

        Stats stats = Singleton.getInstance().getStats();

        String res = "";
        res += stats.getCurrentLevel() + ",";
        res += stats.getCash() + ",";
        res += stats.getCurrentTime() + ",";
        res += stats.getCurrentEnemiesKilled() + ",";
        res += stats.getCurrentLife() + ",";
        res += stats.getCurrentWeapon() + ",";
        res += stats.getCurrentShield();

        return res;

    }

    public static String getInventory() {

        Inventario inventario = Singleton.getInstance().getInventario();
        List<Objetos> objetos = inventario.getLista();
        String res = "";
        for (int i = 0; i < objetos.size(); i++) {
            res += objetos.get(i).getAtributo() + ",";
            res += objetos.get(i).getNombre() + ",";
            res += objetos.get(i).getAmount();
            res += "/";
        }

        return res.substring(0, res.length() - 1);

    }

    public static void sendInventory(String stringInventory) {

        Inventario inventario = new Inventario();

        String[] stringObjetos = stringInventory.split("/");
        List<Objetos> lista = new ArrayList<>();
        for (int i = 0; i < stringObjetos.length; i++) {
            String[] trozos = stringObjetos[i].split(",");
            Objetos objetos = new Objetos();
            objetos.setAtributo(trozos[0]);
            objetos.setAtributo(trozos[1]);
            objetos.setAtributo(trozos[2]);
            lista.add(i, objetos);
        }
        inventario.setLista(lista);
        inventario.setUsername(Singleton.getInstance().getUsername());

        Singleton.getInstance().setInventario(inventario);
        Singleton.getInstance().updateInventario();


    }

    public static String getMap(int level)
    {
        Map map = Singleton.getInstance().getMap(level);

        return map.getMapLevel();
    }
}
