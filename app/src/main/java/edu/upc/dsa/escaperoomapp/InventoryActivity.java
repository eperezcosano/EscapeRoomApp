package edu.upc.dsa.escaperoomapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import edu.upc.dsa.escaperoomapp.models.Objetos;
import edu.upc.dsa.escaperoomapp.models.Stats;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

public class InventoryActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private AuthApi authApi;
    private String username;
    private TextView txtUsername;
    private TextView txtCash;
    private TextView txtHp;
    private RecyclerView recyclerView;
    private MyAdapter recyclerAdapter;
    private List<Objetos> objetosList;
    private TextView txtKilled;
    private TextView txtTime;
    private TextView txtGames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Layout
        setContentView(R.layout.activity_inventory);

        //Loader
        dialog = ProgressDialog.show(InventoryActivity.this, "",
                "Loading. Please wait...", true);

        //Get User Info
        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        //Fields
        txtUsername = findViewById(R.id.txtUsername);
        txtCash = findViewById(R.id.txtCash);
        txtHp = findViewById(R.id.txtHp);
        txtKilled = findViewById(R.id.txtKilled);
        txtTime = findViewById(R.id.txtTime);
        txtGames = findViewById(R.id.txtGames);

        //Recycle View
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new MyAdapter(this, objetosList);
        recyclerView.setAdapter(recyclerAdapter);

        //Api connection
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

        authApi = retrofit.create(AuthApi.class);

        //Api request
        getStats(username);
        //getProfile();
        //getInventory();
    }

    private void getStats(String username) {
        Call<Stats> call = authApi.getStats(username);

        call.enqueue(new Callback<Stats>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<Stats> call, Response<Stats> response) {
                switch (response.code()) {
                    case 201:
                        txtKilled.setText("Enemies killed: " + response.body().getCurrentEnemiesKilled());
                        txtTime.setText("Time: " + response.body().getCurrentTime());
                        txtGames.setText("Games played: " + response.body().getPlayedGames());
                        break;
                    case 404:
                        dialog.dismiss();
                        Toast.makeText(InventoryActivity.this, "First login", Toast.LENGTH_SHORT).show();
                        break;
                    case 600:
                        dialog.dismiss();
                        Toast.makeText(InventoryActivity.this, "Not function for admin", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        dialog.dismiss();
                        Toast.makeText(InventoryActivity.this, "Unknown response", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<Stats> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(InventoryActivity.this, "Connection error", Toast.LENGTH_SHORT).show();
                Log.e("Throwable", t.getMessage());
            }
        });
    }
    private void getProfile() {}

    private void getInventory() {}
}
