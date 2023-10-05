package com.example.wassimelahmar.tutorial03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Apples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);
    }
    public void onClick(View view)
    {
        //creating a new intent objcet, setting the current context to this,
        //and specifying the target activity "Berries.class"
        Intent i = new Intent(this, Berries.class);

        //retrieving the EditText object that contains the user message, we find
        //it using the findViewById function that allows us to retrieve a UI component
        //by it's ID
        final EditText applesTextField = (EditText) findViewById(R.id.applesTextField);

        //getting the actual message contained in the EditText as string
        String userMessage = applesTextField.getText().toString();

        //adding the user message as an additional information with the intent as
        //key-value pair. you can add as much key-value pairs as you want and send them
        //with the intent. You retrieve a value by it's corresponding key
        i.putExtra("appleMessage",userMessage);

        startActivity(i);
    }
}
