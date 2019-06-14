package edu.upc.dsa.escaperoomapp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import edu.upc.dsa.escaperoomapp.models.Inventario;
import edu.upc.dsa.escaperoomapp.models.Map;
import edu.upc.dsa.escaperoomapp.models.Stats;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {
    private static Singleton instance;

    private AuthApi authApi;
    private String username;
    private Stats stats;
    private Inventario inventario;
    private List<Map> map;

    private Singleton() {

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

        this.authApi = retrofit.create(AuthApi.class);

    }

    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void requestStats() {

        Call<Stats> call = authApi.getStats(username);

        call.enqueue(new Callback<Stats>() {
            @Override
            public void onResponse(Call<Stats> call, Response<Stats> response) {

                Log.d("TEST", "OK");
                if (response.isSuccessful())
                {
                    Singleton.getInstance().setStats(response.body());
                    Log.d("TEST", Singleton.getInstance().getStats().toString());
                }


            }

            @Override
            public void onFailure(Call<Stats> call, Throwable t) {
                Log.d("TEST", "fail");
                t.printStackTrace();
            }
        });
    }

    public void sendStats() {
        Call<Void> call = authApi.updateStats(username, stats);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public void requestInventario() {
        Call<Inventario> call = authApi.getInventory(username);

        call.enqueue(new Callback<Inventario>() {
            @Override
            public void onResponse(Call<Inventario> call, Response<Inventario> response) {

                Singleton.getInstance().setInventario(response.body());
            }

            @Override
            public void onFailure(Call<Inventario> call, Throwable t) {

            }
        });
    }

    public void updateInventario() {
        Call<Void> call = authApi.setInventory(this.inventario);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void setMaps(List<Map> maps) {
        this.map = maps;
    }

    public Map getMap(int i) {
        return this.map.get(i);
    }

    public void requestMaps() {

        Call<List<Map>> call = authApi.getMaps();

        call.enqueue(new Callback<List<Map>>() {
            @Override
            public void onResponse(Call<List<Map>> call, Response<List<Map>> response) {
                if (response.isSuccessful())
                    Singleton.getInstance().setMaps(response.body());
            }

            @Override
            public void onFailure(Call<List<Map>> call, Throwable t) {

            }
        });

    }

}
