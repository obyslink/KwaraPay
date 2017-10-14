package ourgames.kwarapay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;

public class KwaraPay extends AppCompatActivity implements OnClickListener {



    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        // Set up click listeners for all the buttons
        View getStartedButton = findViewById(R.id.get_started);
        getStartedButton.setOnClickListener(this);
        View getAirtimeButton = findViewById(R.id.get_airtime);
        getAirtimeButton.setOnClickListener(this);
        View getAtmsButton = findViewById(R.id.get_atms);
        getAtmsButton.setOnClickListener(this);
        View aboutKwPay = findViewById(R.id.about_kwarapay);
        aboutKwPay.setOnClickListener(this);
         View signupMain = findViewById(R.id.login);
        signupMain.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_kwarapay:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
            case R.id.get_started:
                Intent l = new Intent(this, App.class);
                startActivity(l);
                break;
            case R.id.get_airtime:
                Intent j = new Intent(this, QTWebView.class);
                startActivity(j);
                break;
            case R.id.get_atms:
                Intent k = new Intent(this, NearestATMs.class);
                startActivity(k);
                break;
            case R.id.login:
                Intent n = new Intent(this, LogIn.class);
                startActivity(n);
                break;
        }
    }
}