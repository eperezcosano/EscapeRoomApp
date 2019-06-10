package edu.upc.dsa.escaperoomapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.upc.dsa.escaperoomapp.models.User;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

public class LoginActivity extends AppCompatActivity {

    private AuthApi authApi;
    private TextView txtUsername;
    private TextView txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        //Fields
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        Button btnLogin = findViewById(R.id.btnLogIn);

        btnLogin.setOnClickListener(listenerBtnLogIn);

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

    }

    private View.OnClickListener listenerBtnLogIn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty())
                Toast.makeText(LoginActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            else if (username.length() > 7)
                Toast.makeText(LoginActivity.this, "Username must be 7 characters maximum", Toast.LENGTH_SHORT).show();
            else {
                User user = new User("0", username, password);
                login(user);
            }

        }
    };

    private void login(User user) {

        Call<User> call = authApi.login(user);

        call.enqueue(new Callback<User>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                switch (response.code()) {
                    case 200:
                        Intent intent = new Intent(getApplicationContext(), SignedinActivity.class);
                        intent.putExtra("username", response.body().getUsername());
                        intent.putExtra("password", response.body().getPassword());
                        startActivity(intent);
                        break;
                    case 404:
                        Toast.makeText(LoginActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(LoginActivity.this, "Unknown response", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Connection error", Toast.LENGTH_SHORT).show();
                Log.e("Throwable", t.getMessage());
            }
        });
    }

}
