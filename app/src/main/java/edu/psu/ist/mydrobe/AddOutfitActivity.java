package edu.psu.ist.mydrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AddOutfitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outfit);

        Intent intent = getIntent();

        //textviews


    }

    private void setBackgroundColor(int colorId) {
        findViewById(R.id.main_activity).setBackgroundColor(getColor(colorId));
    }
}