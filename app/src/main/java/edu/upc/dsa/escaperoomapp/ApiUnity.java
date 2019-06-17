package edu.upc.dsa.escaperoomapp;

import android.util.Log;

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
            res += objetos.get(i).getType() + ",";
            res += objetos.get(i).getNombre() + ",";
            res += objetos.get(i).getAtributo();
            res += "/";
        }

        return res.substring(0, res.length() - 1);

        //return "llave,llaveR,1/llave,llaveA,2/pista,pistaAmarilla,1/pista,pistaAzul,1";

    }

    public static void sendInventory(String stringInventory) {

        Inventario inventario = new Inventario();

        String[] stringObjetos = stringInventory.split("/");
        List<Objetos> lista = new ArrayList<>();
        for (int i = 0; i < stringObjetos.length; i++) {
            String[] trozos = stringObjetos[i].split(",");
            Objetos objetos = new Objetos();
            objetos.setType(trozos[0]);
            objetos.setNombre(trozos[1]);
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
        Log.d("LEVEL",String.valueOf(Singleton.getInstance().getStats().getCurrentLevel()));
        Log.d("MAPA", map.getMapLevel());
        return map.getMapLevel();
        //return "bbbbbbbOOOOOOOOOOOOOObbbbbbbbbbbbbbLTTTTTTTTTTTTRbbbbbbbbbbbbbbLSSSSSSSSSSSSRbbbbbbbbbbbbbbLSSNSSSSSXSSSRbbbbbbbbbbbbbbLSSSSSSSSSSSSRbbbbbbbbbbbbbbLSSSSSSNSSSSSRbbbbbbbbbbbbbbLSSSSSSSSSSSSRbbbbbbbbbbbbbblBwBcSCBBwBBBrbbbbbbbbbbbbbbbbbOL1ROObbbbbbbbbbbbbbbbbbbbbbLTSTTRbbbbbbbbbbbbbbbbbbbbbbLSSSSRbbbbbbbbbbbbbbbbbbbbbbLSSSSRbOOOOOObbbbbbbbbbbbbbbLSSSSRbLTTTTRbbbbbbbbbbbbbbbLSSSSRbLSSSSRbbbbbbbbbbbbbbbLSSSSRbLSSSSRbbbbbbbbbbbbbbbLSSSSRbLSSNSRbbbbbbbbbbbbbbbLSNSSRbLSSSSRbbbbbOOOOOOOOObLSSSSRblcSCwrbbbbbLTTTTTTTTTTSSSSRbbL3RbbbbbbbLSSSSSSSSSSSSSSTTTTSRbbbbbbbLSSSSSSSSSSSSSSSSSSSRbbbbbbblwwBcSCwBBBwBBwBwBwBrbbbbbbbOOOOL3ROObbbbbbbbbbbbbbbbbbbLTTTTSTTRbbbbbbbbbbbbbbbbbbbLSSSSSSSRbbbbbbbbbbbbbbbbbbbLSSSSSSSRbbbbbbbbbbbbbbbbbbbLSSSSSSSRbbbbbbbbbbbbbbbbbbblwBBwBBBrbbbbbbbbbbbbbbbbbbb*28*4,4,Capital de Espana?-Madrid-Real/18,8,En que equipo juega Messi?-Barcelona-Empieza yor B/11,18,Mas vale tarde que...?-nunca-jamas/5,1,vida-20/7,7,dinero-15/16,6,dinero-30/12,13,vida-10/8,20,dinero-10/12,24,vida-50/6,2,Pepito-Ten cuidado donde pisas...-Podrias llevarte una sorpresa.../3,7,Jaimito-Los enemigos son muy peligrosos en este castillo...-Aunque parezca que no se mueven.../12,16,Pedrito-Has comprado pistas?-En la tienda puedes hacerlo...";
    }

    public static void sendFinalStats(String stringStats)
    {
        Stats stats = new Stats();
        String[] trozos = stringStats.split(",");
        stats.setCurrentLevel(0);
        stats.setCash(Integer.parseInt(trozos[0]));
        stats.setCurrentTime("00:00:00");
        stats.setCurrentEnemiesKilled(0);
        stats.setCurrentLife(200);
        stats.setCurrentWeapon("default");
        stats.setCurrentShield("default");
        stats.setRecordTime(trozos[1]);

        Singleton.getInstance().setStats(stats);
        Singleton.getInstance().sendStats();
    }

}
