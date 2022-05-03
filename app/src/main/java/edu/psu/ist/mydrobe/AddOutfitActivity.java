package edu.psu.ist.mydrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddOutfitActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outfit);

        Intent intent = getIntent();
        int color = intent.getIntExtra(MainActivity.EXTRA_BACKGROUND_COLOR, 0);
        setBackgroundColor(color);

        //textviews
        TextView create = findViewById(R.id.createAnOutfitTitle_label);
        TextView name = findViewById(R.id.nameOfOutfit_label);
        TextView select = findViewById(R.id.selectClothingItems_label);
        TextView shirt = findViewById(R.id.chooseShirt_label);
        TextView shirtSelected = findViewById(R.id.shirtSelectedPlaceholder);
        TextView pants = findViewById(R.id.choosePants_label);
        TextView pantsSelected = findViewById(R.id.pantsSelectedPlaceholder);
        TextView shoes = findViewById(R.id.chooseShoes_label);
        TextView shoesSelected = findViewById(R.id.shoesSelectedPlaceholder);
        TextView jacket = findViewById(R.id.chooseJacket_label);
        TextView jacketSelected = findViewById(R.id.jacketSelectedPlaceholder);
        TextView accessory = findViewById(R.id.chooseAcessory_label);
        TextView accessorySelected = findViewById(R.id.accessorySelectedLayout);

        //edittexts
        TextView nameInput = findViewById(R.id.nameOfOutfit_input);

        //buttons
        Button shirtButton = findViewById(R.id.addShirt_button);
        Button pantsButton = findViewById(R.id.addPants_button);
        Button shoesButton = findViewById(R.id.addShoes_button);
        Button jacketButton = findViewById(R.id.addJacket_button);
        Button accessoryButton = findViewById(R.id.addAccessory_button);
        Button cancel = findViewById(R.id.cancelOutfit_button);
        Button add = findViewById(R.id.createOutfit_button);

        if (color == R.color.highlight_blue){
            //textviews
            create.setTextColor(getColor(R.color.light_blue));
            name.setTextColor(getColor(R.color.light_blue));
            select.setTextColor(getColor(R.color.light_blue));
            shirt.setTextColor(getColor(R.color.light_blue));
            shirtSelected.setTextColor(getColor(R.color.light_blue));
            pants.setTextColor(getColor(R.color.light_blue));
            pantsSelected.setTextColor(getColor(R.color.light_blue));
            shoes.setTextColor(getColor(R.color.light_blue));
            shoesSelected.setTextColor(getColor(R.color.light_blue));
            jacket.setTextColor(getColor(R.color.light_blue));
            jacketSelected.setTextColor(getColor(R.color.light_blue));
            accessory.setTextColor(getColor(R.color.light_blue));
            accessorySelected.setTextColor(getColor(R.color.light_blue));

            //edittexts
            nameInput.setTextColor(getColor(R.color.light_blue));

            //buttons
            add.setBackgroundColor(getColor(R.color.light_blue));
            add.setTextColor(getColor(R.color.highlight_blue));
            shirtButton.setBackgroundColor(getColor(R.color.light_blue));
            shirtButton.setTextColor(getColor(R.color.highlight_blue));
            pantsButton.setBackgroundColor(getColor(R.color.light_blue));
            pantsButton.setTextColor(getColor(R.color.highlight_blue));
            shoesButton.setBackgroundColor(getColor(R.color.light_blue));
            shoesButton.setTextColor(getColor(R.color.highlight_blue));
            jacketButton.setBackgroundColor(getColor(R.color.light_blue));
            jacketButton.setTextColor(getColor(R.color.highlight_blue));
            accessoryButton.setBackgroundColor(getColor(R.color.light_blue));
            accessoryButton.setTextColor(getColor(R.color.highlight_blue));
            cancel.setBackgroundColor(getColor(R.color.light_blue));
            cancel.setTextColor(getColor(R.color.highlight_blue));
        } else {
            //textviews
            create.setTextColor(getColor(R.color.highlight_blue));
            name.setTextColor(getColor(R.color.highlight_blue));
            select.setTextColor(getColor(R.color.highlight_blue));
            shirt.setTextColor(getColor(R.color.highlight_blue));
            shirtSelected.setTextColor(getColor(R.color.highlight_blue));
            pants.setTextColor(getColor(R.color.highlight_blue));
            pantsSelected.setTextColor(getColor(R.color.highlight_blue));
            shoes.setTextColor(getColor(R.color.highlight_blue));
            shoesSelected.setTextColor(getColor(R.color.highlight_blue));
            jacket.setTextColor(getColor(R.color.highlight_blue));
            jacketSelected.setTextColor(getColor(R.color.highlight_blue));
            accessory.setTextColor(getColor(R.color.highlight_blue));
            accessorySelected.setTextColor(getColor(R.color.highlight_blue));

            //edittexts
            nameInput.setTextColor(getColor(R.color.highlight_blue));

            //buttons
            add.setBackgroundColor(getColor(R.color.highlight_blue));
            add.setTextColor(getColor(R.color.white));
            shirtButton.setBackgroundColor(getColor(R.color.highlight_blue));
            shirtButton.setTextColor(getColor(R.color.white));
            pantsButton.setBackgroundColor(getColor(R.color.highlight_blue));
            pantsButton.setTextColor(getColor(R.color.white));
            shoesButton.setBackgroundColor(getColor(R.color.highlight_blue));
            shoesButton.setTextColor(getColor(R.color.white));
            jacketButton.setBackgroundColor(getColor(R.color.highlight_blue));
            jacketButton.setTextColor(getColor(R.color.white));
            accessoryButton.setBackgroundColor(getColor(R.color.highlight_blue));
            accessoryButton.setTextColor(getColor(R.color.white));
            cancel.setBackgroundColor(getColor(R.color.highlight_blue));
            cancel.setTextColor(getColor(R.color.white));
        }

        add.setOnClickListener(this);
        shirtButton.setOnClickListener(this);
        pantsButton.setOnClickListener(this);
        shoesButton.setOnClickListener(this);
        jacketButton.setOnClickListener(this);
        accessoryButton.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    private void setBackgroundColor(int colorId) {
        findViewById(R.id.add_outfit_activity).setBackgroundColor(getColor(colorId));
    }

    @Override
    public void onClick(View view) {
        int eventSource = view.getId();

        Intent viewClothingItems = new Intent(this, ClothingListActivity.class);

        if (eventSource == R.id.addShirt_button || eventSource == R.id.addPants_button
                ||eventSource == R.id.addJacket_button || eventSource == R.id.addAccessory_button
                ||eventSource == R.id.addShoes_button)
        {
            startActivity(viewClothingItems);
        }
        else if (eventSource == R.id.cancel_button)
        {
            finish();
        }
    }

//    private void handleCancel() {
//        finish();
//    }
//
//    private void handleCreate() {
//        finish();
//    }
//
//    private void handleShoes() {
//    }
//
//    private void handleShirt() {
//    }
//
//    private void handlePants() {
//    }
//
//    private void handleJacket() {
//    }
//
//    private void handleAccessory() {
//    }
}