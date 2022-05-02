package edu.psu.ist.mydrobe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.login_button);
        button.setOnClickListener(this);

        Intent intent = getIntent();
        int color = intent.getIntExtra(MainActivity.EXTRA_BACKGROUND_COLOR, 0);
        setBackgroundColor(color);

        TextView name = findViewById(R.id.name);
        TextView pass = findViewById(R.id.textpassword);

        if (color == R.color.highlight_blue){
            button.setBackgroundColor(getColor(R.color.light_blue));
            button.setTextColor(getColor(R.color.highlight_blue));

            pass.setTextColor(getColor(R.color.light_blue));
            name.setTextColor(getColor(R.color.light_blue));
        } else {
            name.setTextColor(getColor(R.color.highlight_blue));
            pass.setTextColor(getColor(R.color.highlight_blue));

            button.setBackgroundColor(getColor(R.color.highlight_blue));
            button.setTextColor(getColor(R.color.white));
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button){
            finish();
        }

    }

    private void setBackgroundColor(int color) {
        findViewById(R.id.add_clothing_activity).setBackgroundColor(getColor(color));
    }
}
