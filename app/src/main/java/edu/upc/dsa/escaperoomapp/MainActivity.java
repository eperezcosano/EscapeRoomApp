package edu.upc.dsa.escaperoomapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Button btnLogIn = findViewById(R.id.btnLogIn);
        Button btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(listenerBtnReg);

    }

    private View.OnClickListener listenerBtnReg = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.google.com"));
            startActivity(browserIntent);
        }
    };
}
