package com.example.nada.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle passedParams = getIntent().getExtras(); //bundle to retrieve the values passed from the first activity
        /*
         * extracting the retrieved values and converting them to integers
         */
        float BILL= Float.parseFloat(passedParams.getString("billAmount"));
        float TIP= Float.parseFloat(passedParams.getString("tip"));
        int NUMPPL=Integer.parseInt(passedParams.getString("numPpl"));

        TextView bill = (TextView) findViewById(R.id.b); //bill is the text view element on the page
        bill.setText("Bill Amount : "+MainActivity.defCurrency+" "+ BILL); //assigning a value to be displayed in the text view element

        TextView tip = (TextView) findViewById(R.id.t);
        float TIPVALUE=(TIP*BILL)/100;
        tip.setText("Tip Amount : "+MainActivity.defCurrency+" "+ TIPVALUE);

        TextView total = (TextView) findViewById(R.id.total);
        float TOTAL=BILL+TIPVALUE;
        total.setText("Total Amount : "+MainActivity.defCurrency+" "+ TOTAL);

        /*
         * Display the tip per person and amount paid by each person only if more than one person is paying
         */
        if(NUMPPL>1) {
            TextView oneTip = (TextView) findViewById(R.id.oneTip);
            float ONETIP = TIPVALUE / NUMPPL;
            oneTip.setText("Tip per person : "+MainActivity.defCurrency+" "+ ONETIP);

            TextView onePay = (TextView) findViewById(R.id.onePay);
            float ONEPAY = TOTAL / NUMPPL;
            onePay.setText("Each person pays: "+MainActivity.defCurrency+" "+ ONEPAY);
        }
    }

}

