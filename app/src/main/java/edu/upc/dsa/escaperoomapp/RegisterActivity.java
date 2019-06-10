package edu.upc.dsa.escaperoomapp;

import android.content.Intent;
import android.nfc.FormatException;
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

public class RegisterActivity extends AppCompatActivity {

    private AuthApi authApi;
    private TextView txtUsername;
    private TextView txtPassword;
    private TextView txtPassword2;
    private TextView txtName;
    private TextView txtSurname;
    private TextView txtEmail;
    private TextView intAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        txtEmail = findViewById(R.id.txtMail);
        intAge = findViewById(R.id.intAge);

        //Button listener
        Button btnReg = findViewById(R.id.btnReg2);
        btnReg.setOnClickListener(listenerBtnReg);

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

    private View.OnClickListener listenerBtnReg = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //Values
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();
            String password2 = txtPassword2.getText().toString();
            String name = txtName.getText().toString();
            String surname = txtSurname.getText().toString();
            String email = txtEmail.getText().toString();
            String txtAge = intAge.getText().toString();

            //Format checking
            if (username.isEmpty() || password.isEmpty() || password2.isEmpty() || name.isEmpty() || surname.isEmpty() || email.isEmpty() || txtAge.isEmpty())
                Toast.makeText(RegisterActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            else if (username.length() > 7)
                Toast.makeText(RegisterActivity.this, "Username must be 7 characters maximum", Toast.LENGTH_SHORT).show();
            else if (!password.equals(password2))
                Toast.makeText(RegisterActivity.this, "Password does not match!", Toast.LENGTH_SHORT).show();
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                Toast.makeText(RegisterActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
            else {
                try {
                    int age = Integer.parseInt(txtAge);
                    //Api post user
                    User user = new User("0", username, password, name, surname, email, age);
                    register(user);

                } catch (NumberFormatException ex) {
                    Toast.makeText(RegisterActivity.this, "Invalid age", Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
        }
    };

    private void register(User user) {

        Call<Void> call = authApi.register(user);
        call.enqueue(new Callback<Void>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                switch (response.code()) {
                    case 201:
                        Intent intent = new Intent(getApplicationContext(), SignedinActivity.class);
                        intent.putExtra("username", txtUsername.getText().toString());
                        startActivity(intent);
                        break;
                    case 404:
                        Toast.makeText(RegisterActivity.this, "Impossible to register", Toast.LENGTH_SHORT).show();
                        break;
                    case 405:
                        Toast.makeText(RegisterActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(RegisterActivity.this, "Unknown response", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Connection error", Toast.LENGTH_SHORT).show();
                Log.e("Throwable", t.getMessage());
            }
        });
    }

}