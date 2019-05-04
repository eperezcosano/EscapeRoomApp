package edu.upc.dsa.escaperoomapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView txtUsername;
    TextView txtPassword;

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

    }

    private View.OnClickListener listenerBtnLogIn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty())
                Toast.makeText(LoginActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            else {
                //
            }

        }
    };

}
