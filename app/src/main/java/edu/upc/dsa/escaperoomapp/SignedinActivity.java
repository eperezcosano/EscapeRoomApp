package edu.upc.dsa.escaperoomapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SignedinActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signedin);

        TextView txtUsername = findViewById(R.id.txtUsername);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/8bit16.ttf");
        txtUsername.setTypeface(custom_font);

        Intent intent = getIntent();
        user = new User(intent.getIntExtra("id", 0), intent.getStringExtra("username"), intent.getStringExtra("password"));

        txtUsername.setText(user.getUsername().concat("!"));

    }
}
