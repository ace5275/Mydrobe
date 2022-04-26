package edu.psu.ist.mydrobe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.imageview.ShapeableImageView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    public static final String TAG = "SETTINGS";

    public static final String EXTRA_DARK_MODE = "RETURN_DARK_MODE_STATE";

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
        Intent returnIntent = new Intent();
        SwitchCompat darkModeSwitch = findViewById(R.id.darkModeSwitch);
        returnIntent.putExtra(MainActivity.RESULT_SETTINGS_CHANGE_THEME, darkModeSwitch.isChecked());

        if (eventSourceId == R.id.settings_back_button) {
            handleBackButtonClick();
        } else if (eventSourceId == R.id.applyButton) {
            // onCheckedChanged(darkModeSwitch, darkModeStatus);
            setResult(RESULT_OK, returnIntent);
            finish();
        }  else if (eventSourceId == R.id.cancelButton) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }

    public void handleBackButtonClick(){
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        findViewById(R.id.settings_activity).setBackgroundColor(getColor(R.color.highlight_blue));
    }
}
