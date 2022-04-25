package edu.psu.ist.mydrobe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView back = findViewById(R.id.settings_back_button);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        if (eventSourceId == R.id.settings_back_button) {
            handleBackButtonClick();
        }
    }

    public void handleBackButtonClick(){
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }
}
