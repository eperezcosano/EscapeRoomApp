package edu.upc.dsa.escaperoomapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class RegisterActivity extends AppCompatActivity {

    private AuthApi authApi;
    private TextView txtUsername;
    private TextView txtPassword;
    private TextView txtPassword2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Layout
        setContentView(R.layout.activity_register);

        //Fields
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtPassword2 = findViewById(R.id.txtPassword2);

        //Button listener
        Button btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(listenerBtnReg);

        //Api connection
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

    private View.OnClickListener listenerBtnReg = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //Values
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();
            String password2 = txtPassword2.getText().toString();

            //Format checking
            if (username.length() > 7)
                Toast.makeText(RegisterActivity.this, "Username must be 7 characters maximum", Toast.LENGTH_SHORT).show();
            else if (!password.equals(password2))
                Toast.makeText(RegisterActivity.this, "Password does not match!", Toast.LENGTH_SHORT).show();
            else {
                //Api post user
                User user = new User(0, username, password);
                register(user);
            }
        }
    };

    private void register(User user) {

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