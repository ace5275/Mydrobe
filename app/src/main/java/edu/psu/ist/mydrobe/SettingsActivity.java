package edu.psu.ist.mydrobe;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

        Intent intent = getIntent();
        int color = intent.getIntExtra(MainActivity.EXTRA_BACKGROUND_COLOR, 0);
        setBackgroundColor(color);
        Log.d(TAG, String.valueOf(color));

        ImageView two = findViewById(R.id.settings_box1);
        ImageView four = findViewById(R.id.settings_box2);

        if (color == R.color.highlight_blue){
            dark.setChecked(true);
            apply.setBackgroundColor(getColor(R.color.light_blue));
            apply.setTextColor(getColor(R.color.highlight_blue));
            cancel.setBackgroundColor(getColor(R.color.light_blue));
            cancel.setTextColor(getColor(R.color.highlight_blue));
            back.setImageResource(R.drawable.vector_1_);
            two.setImageResource(R.drawable.rectangle_26);
            four.setImageResource(R.drawable.rectangle_26_1);
        } else {
            dark.setChecked(false);
            apply.setBackgroundColor(getColor(R.color.highlight_blue));
            apply.setTextColor(getColor(R.color.white));
            cancel.setBackgroundColor(getColor(R.color.highlight_blue));
            cancel.setTextColor(getColor(R.color.white));
            back.setImageResource(R.drawable.leftvector);
            two.setImageResource(R.drawable.rectangle_24);
            four.setImageResource(R.drawable.rectangle_25);
        }
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
        } else if (eventSourceId == R.id.clearButton){
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle("Reset Settings?");
            d.setMessage("Are you sure you want to reset your settings back to default?");

            d.setPositiveButton("RESET", (dialog, i) -> {
                //resets dark mode
                ImageView back = findViewById(R.id.settings_back_button);
                Button apply = findViewById(R.id.applyButton);
                Button cancel = findViewById(R.id.cancelButton);
                SwitchCompat dark = findViewById(R.id.darkModeSwitch);
                ImageView two = findViewById(R.id.settings_box1);
                ImageView four = findViewById(R.id.settings_box2);

                setBackgroundColor(R.color.white);
                dark.setChecked(false);
                apply.setBackgroundColor(getColor(R.color.highlight_blue));
                apply.setTextColor(getColor(R.color.white));
                cancel.setBackgroundColor(getColor(R.color.highlight_blue));
                cancel.setTextColor(getColor(R.color.white));
                back.setImageResource(R.drawable.leftvector);
                two.setImageResource(R.drawable.rectangle_24);
                four.setImageResource(R.drawable.rectangle_25);

                returnIntent.putExtra(MainActivity.RESULT_SETTINGS_CHANGE_THEME, darkModeSwitch.isChecked());
                setResult(RESULT_OK, returnIntent);
                finish();
            });

            d.setNegativeButton("CANCEL", (dialog, i) -> {

            });

            d.show();

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

    private void setBackgroundColor(int color) {
        findViewById(R.id.settings_activity).setBackgroundColor(getColor(color));
    }
}
