package edu.upc.dsa.escaperoomapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.upc.dsa.EscapeRoomUnity.UnityPlayerActivity;


public class UnityActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signedin);
            Intent intent = new Intent(getApplicationContext(), UnityPlayerActivity.class);
            startActivity(intent);
        }
}
