package ourgames.kwarapay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by User on 7/26/2017.
 */

public class ElectricityPSetup extends Activity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elect);

        View subinPay = findViewById(R.id.submit_payment_in);
        subinPay.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_payment_in:
                Intent y = new Intent(this, ProceedingPayment.class);
                startActivity(y);
                break;
        }
    }
}
