package com.example.lab4_300103204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnOpenInGoogleMaps (View view) {
        EditText teamAddres = (EditText) findViewById(R.id.teamAddressField);
    // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddres.getText());
    // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
    // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
    // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
    public void OnSetAvatarButton(View view) {
    //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
    //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);
    //Figuring out the correct image
        String drawableName = "ic_logo_00";
        int imageID = data.getIntExtra("imageID", R.id.logoImage00);

        if (imageID == R.id.logoImage00) {
            drawableName = "ic_logo_00";
        } else if (imageID == R.id.logoImage01) {
            drawableName = "ic_logo_01";
        } else if (imageID == R.id.logoImage02) {
            drawableName = "ic_logo_02";
        } else if (imageID == R.id.logoImage03) {
            drawableName = "ic_logo_03";
        } else if (imageID == R.id.logoImage04) {
            drawableName = "ic_logo_04";
        } else if (imageID == R.id.logoImage05) {
            drawableName = "ic_logo_05";
        } else {
            drawableName = "ic_logo_00";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}