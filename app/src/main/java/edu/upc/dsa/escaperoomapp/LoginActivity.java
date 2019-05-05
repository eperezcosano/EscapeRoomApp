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

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        Button btnLogin = findViewById(R.id.btnLogIn);

        btnLogin.setOnClickListener(listenerBtnLogIn);

        Gson gson = new GsonBuilder().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/eperezcosano/JSON-server/")
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
            else if (username.length() > 7) //TODO Register
                Toast.makeText(LoginActivity.this, "Username must be 7 characters maximum", Toast.LENGTH_SHORT).show();
            else {
                User user = new User(0, username, password);
                //login(user);
                Intent intent = new Intent(getApplicationContext(), SignedinActivity.class);
                intent.putExtra("id", user.getId());
                intent.putExtra("username", user.getUsername());
                intent.putExtra("password", user.getPassword());
                startActivity(intent);
            }

        }
    };

    private void login(User user) {

        Call<User> call = authApi.login(user);

        call.enqueue(new Callback<User>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Log.e("Code", Integer.toString(response.code()));
                    return;
                }

                Log.v("Response", response.body().toString());
                //if (response.isSuccessful())
                    //Open Session
                //if (response.code() == )


            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Throwable", t.getMessage());
            }
        });
    }

}
