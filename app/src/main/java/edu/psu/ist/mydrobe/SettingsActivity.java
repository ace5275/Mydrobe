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

        if (eventSourceId == R.id.settings_back_button) {
            handleBackButtonClick();
        } else if (eventSourceId == R.id.applyButton) {
            handleApplyButtonClick();
        }  else if (eventSourceId == R.id.cancelButton) {
            handleBackButtonClick();
        }
    }

    public void handleBackButtonClick(){
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }

    public void handleApplyButtonClick(){
        Intent apply = new Intent(this, MainActivity.class);

        mGetStatus.launch(apply);
    }

    ActivityResultLauncher<Intent> mGetStatus = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                int resultCode = result.getResultCode();
                if (resultCode == RESULT_OK) {
                    assert result.getData() != null;
                    boolean darkModeStatus = result.getData().getBooleanExtra(EXTRA_DARK_MODE, false);

                    SwitchCompat darkModeSwitch = findViewById(R.id.darkModeSwitch);
                    if (darkModeSwitch.isChecked() != darkModeStatus) {
                        onCheckedChanged(darkModeSwitch, darkModeStatus);
                    }
                } else if (resultCode == RESULT_CANCELED) {
                    Log.d(TAG, "Canceled from ShowProfileDetailsActivity");
                } else {
                    Log.d(TAG, String.format("Unknown return code from ShowProfileDetailsActivity: %s", resultCode));
                }
            }
    );

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.RESULT_SETTINGS_CHANGE_THEME, compoundButton.isChecked());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
