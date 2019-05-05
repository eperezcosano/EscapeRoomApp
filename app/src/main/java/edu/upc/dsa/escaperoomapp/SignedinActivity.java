package edu.upc.dsa.escaperoomapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
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
        //Layout
        setContentView(R.layout.activity_signedin);

        //8Bit Font
        TextView txtUsername = findViewById(R.id.txtUsername);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/8bit16.ttf");
        txtUsername.setTypeface(custom_font);

        //Get user data
        Intent intent = getIntent();
        user = new User(intent.getIntExtra("id", 0), intent.getStringExtra("username"), intent.getStringExtra("password"));

        txtUsername.setText(user.getUsername().concat("!"));

        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnShop = findViewById(R.id.btnShop);
        Button btnInventory = findViewById(R.id.btnInventory);

        btnPlay.setOnClickListener(listenerBtnPlay);
        btnShop.setOnClickListener(listenerBtnShop);
        btnInventory.setOnClickListener(listenerBtnInventory);

    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

    private View.OnClickListener listenerBtnPlay = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SignedinActivity.this);
            builder.setMessage("Do you want to continue?").setPositiveButton("Continue", dialogClickListener)
                    .setNegativeButton("New game", dialogClickListener).show();
        }
    };

    private View.OnClickListener listenerBtnShop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.google.com"));
            startActivity(browserIntent);
        }
    };

    private View.OnClickListener listenerBtnInventory = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Intent inventoryIntent = new Intent(getApplicationContext(), )
            //startActivity(inventoryIntent);
        }
    };
}
