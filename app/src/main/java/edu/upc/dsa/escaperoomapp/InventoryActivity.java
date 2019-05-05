package edu.upc.dsa.escaperoomapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class InventoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Layout
        setContentView(R.layout.activity_inventory);

        //Get User Info
        Intent intent = getIntent();
        //bla bla

        TextView txtUsername = findViewById(R.id.txtUsername);
        TextView txtCash = findViewById(R.id.txtCash);
        TextView txtHp = findViewById(R.id.txtHp);

        //recycleview

    }
}
