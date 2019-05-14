package edu.upc.dsa.escaperoomapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Intent musicService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        musicService = new Intent(this, BackgroundSoundService.class);
        startService(musicService);

        Button btnLogIn = findViewById(R.id.btnLogIn);
        Button btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(listenerBtnReg);
        btnLogIn.setOnClickListener(listenerBtnLogIn);

    }

    private View.OnClickListener listenerBtnReg = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent registerIntent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(registerIntent);
        }
    };

    private View.OnClickListener listenerBtnLogIn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(loginIntent);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(musicService);
        Log.d("SERVICE", "onBackPressed called");
    }

}
