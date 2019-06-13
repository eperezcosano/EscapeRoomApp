package edu.upc.dsa.escaperoomapp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import edu.upc.dsa.escaperoomapp.models.Inventario;
import edu.upc.dsa.escaperoomapp.models.Objetos;
import edu.upc.dsa.escaperoomapp.models.Stats;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUnity {


    public static AuthApi getConnection() {

        Gson gson = new GsonBuilder().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://147.83.7.205:8080/dsaApp/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit.create(AuthApi.class);
    }


    public static void sendStats(String stats)
    {
        Log.d("TEST", "Los stats recibidos son: " + stats);
    }

    public static String getPlayerStats() {

        String username = Username.getInstance().getUsername();

        Call<Stats> call = getConnection().getStats(username);

        final String res = "";


        call.enqueue(new Callback<Stats>() {
            @Override
            public void onResponse(Call<Stats> call, Response<Stats> response) {

                Stats stats = response.body();


                res.concat(stats.getCurrentLevel() + ",");
                res.concat(stats.getCash() + ",");
                res.concat(stats.getCurrentTime() + ",");
                res.concat(stats.getCurrentEnemiesKilled() + ",");
                res.concat(stats.getCurrentWeapon() + ",");
                res.concat(stats.getCurrentShield());


            }

            @Override
            public void onFailure(Call<Stats> call, Throwable t) {

            }
        });

        Log.d("TEST", "res: " + res);
        return res;

    }

    public static String getInventory() {
        return "llave,llaveR,1/llave,llaveA,2/pista,pistaAmarilla,1/pista,pistaAzul,1";
    }

    public static String getMap(int level)
    {
        String map;

        switch (level) {
            case 1:
                map = "bbbbbbbOOOOOOOOOOOOOObbbbbbb" +
                        "bbbbbbbLTTTTTTTTTTTTRbbbbbbb" +
                        "bbbbbbbLV          VRbbbbbbb" +
                        "bbbbbbbL  N     X   Rbbbbbbb" +
                        "bbbbbbbL            Rbbbbbbb" +
                        "bbbbbbbL      N     Rbbbbbbb" +
                        "bbbbbbbL            Rbbbbbbb" +
                        "bbbbbbblBwBc CBBwBBBrbbbbbbb" +
                        "bbbbbbbbbbOL1ROObbbbbbbbbbbb" +
                        "bbbbbbbbbbLf fTRbbbbbbbbbbbb" +
                        "bbbbbbbbbbLV   Rbbbbbbbbbbbb" +
                        "bbbbbbbbbbL    RbOOOOOObbbbb" +
                        "bbbbbbbbbbL    RbLTTTTRbbbbb" +
                        "bbbbbbbbbbL    RbL    Rbbbbb" +
                        "bbbbbbbbbbL    RbL    Rbbbbb" +
                        "bbbbbbbbbbL    RbL  N Rbbbbb" +
                        "bbbbbbbbbbL N  RbL    Rbbbbb" +
                        "OOOOOOOOObL    Rblc Cwrbbbbb" +
                        "LTTTTTTTTTT    ROOL3RObbbbbb" +
                        "LV             TTTf fRbbbbbb" +
                        "L                    Rbbbbbb" +
                        "lwwBc CwBBBwBBwBwBwBBrbbbbbb" +
                        "OOOOL3ROObbbbbbbbbbbbbbbbbbb" +
                        "LTTTf fTRbbbbbbbbbbbbbbbbbbb" +
                        "LV      Rbbbbbbbbbbbbbbbbbbb" +
                        "L       Rbbbbbbbbbbbbbbbbbbb" +
                        "L X    VRbbbbbbbbbbbbbbbbbbb" +
                        "lwBBwBBBrbbbbbbbbbbbbbbbbbbb*28*"+
                        "4,4,Capital de España?-Madrid-Real/"+
                        "18,8,En qué equipo juega Messi?-Barcelona-Empieza por B/"+
                        "11,18,Mas vale tarde que...?-nunca-jamás";
                break;
            case 2:
                map = "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "OOOOOOOOOOOOOOOOOO" +
                        "LTTTTTTTTTTTTTTTTR" +
                        "L                R" +
                        "L                R" +
                        "lwwBc CwBBwBwwBwBr" +
                        "OOOOL3ROObbbbbbbbb" +
                        "LTTTf fTRbbbbbbbbb" +
                        "L       Rbbbbbbbbb" +
                        "L       Rbbbbbbbbb" +
                        "L       Rbbbbbbbbb" +
                        "lwBBwBBBrbbbbbbbbb*18*"+
                        "4,4,Quien es el más feo de la UPC?-Mario-Empieza por M";
                break;
            default:
                map = "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "bbbbbbbbbbbbbbbbbb" +
                        "OOOOOOOOOOOOOOOOOO" +
                        "LTTTTTTTTTTTTTTTTR" +
                        "L                R" +
                        "L                R" +
                        "lwwBc CwBBwBwwBwBr" +
                        "OOOOL3ROObbbbbbbbb" +
                        "LTTTf fTRbbbbbbbbb" +
                        "L       Rbbbbbbbbb" +
                        "L       Rbbbbbbbbb" +
                        "L       Rbbbbbbbbb" +
                        "lwBBwBBBrbbbbbbbbb*18*"+
                        "4,4,Quien es el más feo de la UPC?-Mario-Empieza por M";
                break;
        }

        return map;
    }
}
