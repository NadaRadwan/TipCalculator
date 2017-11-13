package com.example.nada.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Suggestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
    }

    public void calcSuggested(View view){
        RatingBar ratingB= (RatingBar)findViewById(R.id.rating);//rating is the id of the rating bar element on the page
        float SUGGESTED=2*ratingB.getRating()+10; //we calculate the suggested value using the provided formula
        TextView suggested = (TextView) findViewById(R.id.suggested); //suggested is id of the text view element on the page; we fetch it to add a value to be displayed on page
        suggested.setText("Suggested Tip: "+ SUGGESTED+"%"); //assigning a value to be displayed in the text view element
    }
}
