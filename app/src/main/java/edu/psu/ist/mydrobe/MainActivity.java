/*
  MainActivity.java
  Version: 4.13.2022
 */

package edu.psu.ist.mydrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.imageview.ShapeableImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Mydrobe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView outfits = findViewById(R.id.outfits_button);
        outfits.setOnClickListener(this);

        ImageView upload = findViewById(R.id.upload_button);
        upload.setOnClickListener(this);

        ImageView camera = findViewById(R.id.camera_button);
        camera.setOnClickListener(this);

        ImageView settings = findViewById(R.id.settings_button);
        settings.setOnClickListener(this);

        ImageView profile = findViewById(R.id.profile_button);
        profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        if (eventSourceId == R.id.outfits_button) {
            handleOutfitsButtonClick();
        } else if (eventSourceId == R.id.upload_button) {
            handleUploadButtonClick();
        } else if (eventSourceId == R.id.camera_button) {
            handleCameraButtonClick();
        } else if(eventSourceId == R.id.settings_button) {
            handleSettingsButtonClick();
        } else if(eventSourceId == R.id.profile_button){
            handleProfileButtonClick();
        } else {
            Log.d(TAG, String.format("Unknown click event source: %s", eventSourceId));
        }
    }

    public void handleOutfitsButtonClick(){
        //create intent and call startActivity

    }

    public void handleUploadButtonClick(){

    }

    public void handleCameraButtonClick(){

    }

    public void handleSettingsButtonClick(){

    }

    public void handleProfileButtonClick(){

    }
}