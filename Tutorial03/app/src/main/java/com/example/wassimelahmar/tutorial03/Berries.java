package com.example.wassimelahmar.tutorial03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Berries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berries);

        //Retrieve the extra information sent with the intent that called this activity
        //and store them in a Bundle object
        Bundle applesData = getIntent().getExtras();

        //if the bundle is null, this means the user did not sent any extra information
        //in that case, return. We only want to open the activity if the user sent something
        if(applesData == null)
        {
            return;
        }

        //retrieve the message that was sent with the intent using it's key, "appleMessage"
        String appleMessage = applesData.getString("appleMessage");

        //retrieve the TextView object that we want to display the user message in
        final TextView berriesTextView = (TextView) findViewById(R.id.berriesTextView);

        //set the text of this retrieved object to the user message
        berriesTextView.setText(appleMessage);
    }
}
