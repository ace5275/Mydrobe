package edu.psu.ist.mydrobe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        Button apply = findViewById(R.id.applyButton);
        apply.setOnClickListener(this);

        Button cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(this);

        Button clear = findViewById(R.id.clearButton);
        clear.setOnClickListener(this);

        SwitchCompat dark = findViewById(R.id.darkModeSwitch);
        dark.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();
        Intent returnIntent = new Intent();
        SwitchCompat darkModeSwitch = findViewById(R.id.darkModeSwitch);
        Log.d(TAG, "inside onClick in settings");

        if (eventSourceId == R.id.settings_back_button) {
            handleBackButtonClick();
        } else if (eventSourceId == R.id.applyButton) {
            Log.d(TAG, "inside apply if");
            // onCheckedChanged(darkModeSwitch, darkModeStatus);
            returnIntent.putExtra(MainActivity.RESULT_SETTINGS_CHANGE_THEME, darkModeSwitch.isChecked());
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
