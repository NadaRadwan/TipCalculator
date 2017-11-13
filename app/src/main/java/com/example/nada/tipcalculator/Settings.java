package com.example.nada.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ListView currencyList= (ListView) findViewById(R.id.defaultCurrencyList);

        // ListView on item selected listener.
        currencyList.setOnItemClickListener(new OnItemClickListener()
        {
            /*
             *parent: The AdapterView where the click happened. (ListView)

             *view: The view within the AdapterView that was clicked (this will be a view provided by the adapter)

             *position: The position of the view in the adapter.

             *id: The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(Settings.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                MainActivity.defCurrency=((TextView) view).getText().toString();
            }
        });
    }


    public void saveSettings(View view){
        Toast.makeText(getApplicationContext(), "Settings saved", Toast.LENGTH_SHORT).show(); //display small window saying "settings saved"

        EditText defaultTip = (EditText) findViewById(R.id.defaultTip);
        if(defaultTip.getText().toString().length()!=0) {
            MainActivity.defTip = Float.parseFloat(defaultTip.getText().toString()); //setting the global static variable defTip
        }
    }
//        MainActivity.defCurrency=currencyList.getSelectedItem().toString(); //setting the global static variable defCurrency
    }

