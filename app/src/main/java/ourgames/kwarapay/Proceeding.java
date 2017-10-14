package ourgames.kwarapay;

import android.app.Activity;
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

/**
 * Created by User on 7/26/2017.
 */

public class Proceeding extends Activity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceed1);

        View procPay = findViewById(R.id.proceed_btn2);
        procPay.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.proceed_btn2:
                Intent y = new Intent(this, ElectricityPSetup.class);
                startActivity(y);
                break;
        }
    }
    }
