package com.example.nada.tipcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;
import android.view.Menu;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.Integer;

public class MainActivity extends AppCompatActivity {

    public static float defTip; //default tip
    public static String defCurrency="$"; //default currency

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        /*if no default tip was set, set the default tip to 0*/
        EditText tip = (EditText) findViewById(R.id.tip);
        tip.setText(Float.toString(defTip));
    }

    /*
     *We are inflating the menu_main xml file in java. "Inflating" a view means taking the layout XML and parsing it to create
     * the view and view group objects from the elements and their attributes specified 
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
     *If an action from the menu is selected, the onOptionsItemSelected() method in the corresponding activity is called.
     * It receives the selected action as parameter
     *Based on this information, you can decide what to do.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                settings();
                //setting the default tip
                return true;
            default:
                return super.onOptionsItemSelected(item); //the default implementation of the method in the super class returns false
        }

    }

    public void calcTip(View view) {
        boolean complete = true; //boolean to check if the tip should be calculated
        /*
         * extracting values entered by user
         */
        EditText billAmount = (EditText) findViewById(R.id.billAmount);
        EditText tip = (EditText) findViewById(R.id.tip);
        EditText numPpl = (EditText) findViewById(R.id.numPpl);

        /*
         *validation checks
         */
        if (billAmount.getText().toString().length() == 0) {
            complete = false;
            billAmount.setError("Please specify the bill amount!");
        }

        if (tip.getText().toString().length() == 0) {
            /*
             * set the tip to the default tip value if nothing was entered
             * if no default tip is set, set the tip to 0.0
             */
              tip.setText(Float.toString(defTip));
        }

        if (numPpl.getText().toString().length() == 0) {
            complete = false;
            numPpl.setError("Please specify the number of people!");
        }

        if (complete) {
            //Toast.makeText(getApplicationContext(), "Beep Bop", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Summary.class); //create a new intent that creates a new activity and allows us to pass parameters between the current activity and the created activity
            //passing the parameters to the new activity
            i.putExtra("billAmount", billAmount.getText().toString());
            i.putExtra("tip", tip.getText().toString());
            i.putExtra("numPpl", numPpl.getText().toString());
            startActivity(i); //navigates to the next page (summary)
        }
    }

    public void suggestTip(View view) {
        //tip suggestion
        Intent j = new Intent(MainActivity.this, Suggestion.class); //create a new intent that creates a new activity and allows us to pass parameters between the current activity and the created activity
        //passing the parameters to the new activity
        startActivity(j); //navigates to the next page (suggestion)
    }

    /*
     *settings() is called when the settings action is selected from the menu
     */
    public void settings() {
        //tip suggestion
        Intent k = new Intent(MainActivity.this, Settings.class); //create a new intent that creates a new activity and allows us to pass parameters between the current activity and the created activity
        //passing the parameters to the new activity
        startActivity(k); //navigates to the next page (suggestion)
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.nada.tipcalculator/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.nada.tipcalculator/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
