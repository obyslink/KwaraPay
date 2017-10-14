package ourgames.kwarapay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by User on 7/24/2017.
 */

public class LogIn extends Activity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        View subPay = findViewById(R.id.submit_log_in);
        subPay.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_log_in:
                Intent y = new Intent(this, Proceeding.class);
                startActivity(y);
                break;
        }
    }
}
