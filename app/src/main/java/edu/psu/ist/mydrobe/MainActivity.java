/*
  MainActivity.java
  Version: 4.13.2022
  Description: 
 */

package edu.psu.ist.mydrobe;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Mydrobe";

    public static final String RESULT_SETTINGS_CHANGE_THEME = "SHOULD_CHANGE_THEME";
    public static final String RESULT_SETTINGS_CLEAR_PREFS = "SHOULD_CLEAR_PREF";

    public static final String EXTRA_BACKGROUND_COLOR = "BACKGROUND_COLOR";

    private SharedPreferences sharedPreferences;

    private final static String SHARED_PREF_BACKGROUND_COLOR_KEY = "BACKGROUND_COLOR";
    private final static int DEFAULT_BACKGROUND_COLOR_ID = R.color.white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView outfits = findViewById(R.id.outfits_button);
        outfits.setOnClickListener(this);

        ImageView upload = findViewById(R.id.upload_button);
        upload.setOnClickListener(this);

        ImageView settings = findViewById(R.id.settings_button);
        settings.setOnClickListener(this);

        ImageView profile = findViewById(R.id.profile_button);
        profile.setOnClickListener(this);

        ShapeableImageView carousel = findViewById(R.id.carouselView);
        carousel.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(getString(R.string.shared_pref_mydrobe), MODE_PRIVATE);

        // clearAllProfilePreferences();

        TextView row1 = findViewById(R.id.home_first_row_text);
        TextView row2 = findViewById(R.id.home_second_row_text);
        if (sharedPreferences.getInt(EXTRA_BACKGROUND_COLOR, 0) == R.color.highlight_blue){
            // changeAppTheme();
            saveAndSetBackgroundColorId(R.color.highlight_blue);
            row1.setTextColor(getColor(R.color.light_blue));
            row2.setTextColor(getColor(R.color.light_blue));
        } else {
            saveAndSetBackgroundColorId(R.color.white);
            row1.setTextColor(getColor(R.color.highlight_blue));
            row2.setTextColor(getColor(R.color.highlight_blue));
        }
    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        if (eventSourceId == R.id.outfits_button) {
            handleOutfitsButtonClick();
        } else if (eventSourceId == R.id.upload_button) {
            handleUploadButtonClick();
        } else if(eventSourceId == R.id.settings_button) {
            handleSettingsButtonClick();
        } else if(eventSourceId == R.id.profile_button){
            handleProfileButtonClick();
        } else if(eventSourceId == R.id.carouselView){
            handleCarouselButtonClick();
        } else {
            Log.d(TAG, String.format("Unknown click event source: %s", eventSourceId));
        }
    }

    public void handleOutfitsButtonClick(){
        //create intent and call startActivity
        Intent addOutfitActivity = new Intent(this, ClothingListActivity.class);
        mGetStatus.launch(addOutfitActivity);



    }

    public void handleUploadButtonClick()
    {
        Intent addClothingItemActivity = new Intent(this, AddClothingItemActivity.class);

        int bgc = retrieveBackgroundColorId();
        addClothingItemActivity.putExtra(EXTRA_BACKGROUND_COLOR, bgc);

        mGetStatus.launch(addClothingItemActivity);

    }

    public void handleCameraButtonClick(){

    }

    public void handleSettingsButtonClick(){
        Intent settingsItemActivity = new Intent(this, SettingsActivity.class);

        int bgc = retrieveBackgroundColorId();
        settingsItemActivity.putExtra(EXTRA_BACKGROUND_COLOR, bgc);

        mGetStatus.launch(settingsItemActivity);
    }

    public void handleProfileButtonClick(){

    }

    public void handleCarouselButtonClick(){

    }

    @SuppressLint("ResourceAsColor")
    ActivityResultLauncher<Intent> mGetStatus = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                int resultCode = result.getResultCode();
                if (resultCode == RESULT_OK) {
                    assert result.getData() != null;
                    boolean dark = result.getData().getBooleanExtra(RESULT_SETTINGS_CHANGE_THEME,
                            false);
                    boolean clear = result.getData().getBooleanExtra(RESULT_SETTINGS_CLEAR_PREFS,
                            false);

                    TextView row1 = findViewById(R.id.home_first_row_text);
                    TextView row2 = findViewById(R.id.home_second_row_text);

                    if (dark){
                        // changeAppTheme();
                        saveAndSetBackgroundColorId(R.color.highlight_blue);
                        row1.setTextColor(getColor(R.color.light_blue));
                        row2.setTextColor(getColor(R.color.light_blue));
                    } else {
                        saveAndSetBackgroundColorId(R.color.white);
                        row1.setTextColor(getColor(R.color.highlight_blue));
                        row2.setTextColor(getColor(R.color.highlight_blue));
                    }
                    if (clear){
                        clearAllProfilePreferences();
                    }
                } else if (resultCode == RESULT_CANCELED){
                    Log.d(TAG, "settings activity canceled");
                }
            }
    );

    private int retrieveBackgroundColorId() {
        return sharedPreferences.getInt(SHARED_PREF_BACKGROUND_COLOR_KEY, DEFAULT_BACKGROUND_COLOR_ID);
    }

    /*private void changeAppTheme() {
        int currentColorId = sharedPreferences.getInt(SHARED_PREF_BACKGROUND_COLOR_KEY, DEFAULT_BACKGROUND_COLOR_ID);
        int nextColorId = R.color.white;

        if (currentColorId == R.color.white)
            nextColorId = R.color.highlight_blue;

        saveAndSetBackgroundColorId(nextColorId);
    }*/

    private void saveAndSetBackgroundColorId(int colorId) {
        saveBackGroundColorId(colorId);
        setBackgroundColor(colorId);
    }

    private void saveBackGroundColorId(int colorId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREF_BACKGROUND_COLOR_KEY, colorId);
        editor.apply();
    }

    private void setBackgroundColor(int colorId) {
        findViewById(R.id.main_activity).setBackgroundColor(getColor(colorId));
    }

    private void clearAllProfilePreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
    }
}