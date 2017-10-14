package ourgames.kwarapay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;
/**
 * Created by User on 7/24/2017.
 */

public class App extends AppCompatActivity implements OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textviewz);

        View registrationAttempt = findViewById(R.id.register_attempt);
        registrationAttempt.setOnClickListener(this);
        View visitourwebAttempt = findViewById(R.id.visitourweb);
        visitourwebAttempt.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_attempt:
                Intent ij = new Intent(this, SignUp.class);
                startActivity(ij);
                          break;
            case R.id.visitourweb:
                Intent jh = new Intent(this, KwaraPayWeb.class);
                startActivity(jh);
                break;
}
  }
    }


