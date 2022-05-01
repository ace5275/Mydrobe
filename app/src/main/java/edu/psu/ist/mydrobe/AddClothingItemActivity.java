package edu.psu.ist.mydrobe;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AddClothingItemActivity extends AppCompatActivity implements View.OnClickListener
{
    Spinner clothingCategorySpinner, materialSpinner;
    Wardrobe wardrobe = new Wardrobe();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothing_item);

        clothingCategorySpinner = findViewById(R.id.clothingCategory_spinner);
        materialSpinner = findViewById(R.id.material_spinner);

        //ArrayAdapter is set up so that the spinner
        //displays the list of clothing types/categories
        ArrayAdapter<CharSequence> clothingCategoryAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.clothing_categories,
                        android.R.layout.simple_spinner_item);
        clothingCategoryAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        //ArrayAdapter is set up so that the spinner
        //displays the list of clothing materials
        ArrayAdapter<CharSequence> materialAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.materials,
                        android.R.layout.simple_spinner_item);
        materialAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        clothingCategorySpinner.setAdapter(clothingCategoryAdapter);
        materialSpinner.setAdapter(materialAdapter);

        Button takePicture = findViewById(R.id.takePicture_button);
        takePicture.setOnClickListener(this);

        Button addClothingItem = findViewById(R.id.addClothingItem_button);
        addClothingItem.setOnClickListener(this);

        //views and color changes for dark mode
        //textviews
        TextView title = findViewById(R.id.addClothingItemTitle_label);
        TextView cat = findViewById(R.id.clothingCategory_label);
        TextView brand = findViewById(R.id.brand_label);
        TextView size = findViewById(R.id.size_label);
        TextView colors = findViewById(R.id.colors_label);
        TextView material = findViewById(R.id.material_label);
        TextView photo = findViewById(R.id.photoOfClothing_label);
        TextView seasons = findViewById(R.id.seasons_label);

        //checkboxes
        CheckBox red = findViewById(R.id.redCheckBox);
        CheckBox orange = findViewById(R.id.orangeCheckBox);
        CheckBox yellow = findViewById(R.id.yellowCheckBox);
        CheckBox green = findViewById(R.id.greenCheckBox);
        CheckBox grey = findViewById(R.id.greyCheckBox2);
        CheckBox blue = findViewById(R.id.blueCheckBox);
        CheckBox black = findViewById(R.id.blackCheckBox);
        CheckBox purple = findViewById(R.id.purpleCheckBox);
        CheckBox fall = findViewById(R.id.fallCheckBox);
        CheckBox winter = findViewById(R.id.winterCheckBox);
        CheckBox spring = findViewById(R.id.springCheckBox);
        CheckBox summer = findViewById(R.id.summerCheckBox);

        //buttons
        Button pic = findViewById(R.id.takePicture_button);
        Button add = findViewById(R.id.addClothingItem_button);

        Intent intent = getIntent();
        int color = intent.getIntExtra(MainActivity.EXTRA_BACKGROUND_COLOR, 0);
        setBackgroundColor(color);
        if (color == R.color.highlight_blue){
            //labels
            title.setTextColor(getColor(R.color.light_blue));
            cat.setTextColor(getColor(R.color.light_blue));
            brand.setTextColor(getColor(R.color.light_blue));
            size.setTextColor(getColor(R.color.light_blue));
            colors.setTextColor(getColor(R.color.light_blue));
            material.setTextColor(getColor(R.color.light_blue));
            photo.setTextColor(getColor(R.color.light_blue));
            seasons.setTextColor(getColor(R.color.light_blue));

            //checkboxes
            red.setTextColor(getColor(R.color.light_blue));
            orange.setTextColor(getColor(R.color.light_blue));
            yellow.setTextColor(getColor(R.color.light_blue));
            green.setTextColor(getColor(R.color.light_blue));
            grey.setTextColor(getColor(R.color.light_blue));
            black.setTextColor(getColor(R.color.light_blue));
            blue.setTextColor(getColor(R.color.light_blue));
            purple.setTextColor(getColor(R.color.light_blue));
            fall.setTextColor(getColor(R.color.light_blue));
            winter.setTextColor(getColor(R.color.light_blue));
            spring.setTextColor(getColor(R.color.light_blue));
            summer.setTextColor(getColor(R.color.light_blue));

            //buttons
            add.setBackgroundColor(getColor(R.color.light_blue));
            add.setTextColor(getColor(R.color.highlight_blue));
            pic.setBackgroundColor(getColor(R.color.light_blue));
            pic.setTextColor(getColor(R.color.highlight_blue));
        } else {
            //labels
            title.setTextColor(getColor(R.color.highlight_blue));
            cat.setTextColor(getColor(R.color.highlight_blue));
            brand.setTextColor(getColor(R.color.highlight_blue));
            size.setTextColor(getColor(R.color.highlight_blue));
            colors.setTextColor(getColor(R.color.highlight_blue));
            material.setTextColor(getColor(R.color.highlight_blue));
            photo.setTextColor(getColor(R.color.highlight_blue));
            seasons.setTextColor(getColor(R.color.highlight_blue));

            //checkboxes
            red.setTextColor(getColor(R.color.highlight_blue));
            orange.setTextColor(getColor(R.color.highlight_blue));
            yellow.setTextColor(getColor(R.color.highlight_blue));
            green.setTextColor(getColor(R.color.highlight_blue));
            grey.setTextColor(getColor(R.color.highlight_blue));
            black.setTextColor(getColor(R.color.highlight_blue));
            blue.setTextColor(getColor(R.color.highlight_blue));
            purple.setTextColor(getColor(R.color.highlight_blue));
            fall.setTextColor(getColor(R.color.highlight_blue));
            winter.setTextColor(getColor(R.color.highlight_blue));
            spring.setTextColor(getColor(R.color.highlight_blue));
            summer.setTextColor(getColor(R.color.highlight_blue));

            //buttons
            add.setBackgroundColor(getColor(R.color.highlight_blue));
            add.setTextColor(getColor(R.color.white));
            pic.setBackgroundColor(getColor(R.color.highlight_blue));
            pic.setTextColor(getColor(R.color.white));
        }

    }
    ActivityResultLauncher<Intent> mCaptureImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>()
            {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int resultCode = result.getResultCode();
                    if (resultCode == RESULT_OK) {
                        assert result.getData() != null;
                        Bitmap imageBitmap = (Bitmap) result.getData().getExtras().get("data");
                        ImageView imageFromCamera = findViewById(R.id.imageView);
                        imageFromCamera.setImageBitmap(imageBitmap);

                    } else if (resultCode == RESULT_CANCELED) {
                        Log.d("AddingClothingItemActivity:", "Canceled without taking an image");
                    } else {
                        Log.d("AddingClothingItemActivity:", String.format("Unknown return code from the Camera App: %s", resultCode));
                    }
                }
            }
    );

    @Override
    public void onClick(View view)
    {
        int eventSource = view.getId();

        Intent returnIntent = new Intent();

        //Retrieving selected clothing type from spinner
        String selectedCategory = (String) clothingCategorySpinner.getSelectedItem();

        //Retrieving selected material type from spinner
        String selectedMaterial = (String) materialSpinner.getSelectedItem();

        //Retrieving size input
        EditText sizeInput = findViewById(R.id.size_input);
        double size = Double.parseDouble(sizeInput.getText().toString());

        //Retrieving brand input
        EditText brandInput = findViewById(R.id.brand_input);
        String brand = brandInput.getText().toString();

        //Retrieving views of the checkboxes
        CheckBox redCheckBox = findViewById(R.id.redCheckBox);
        CheckBox blueCheckBox = findViewById(R.id.blueCheckBox);
        CheckBox orangeCheckBox = findViewById(R.id.orangeCheckBox);
        CheckBox yellowCheckBox = findViewById(R.id.yellowCheckBox);
        CheckBox greenCheckBox = findViewById(R.id.greenCheckBox);
        CheckBox purpleCheckBox = findViewById(R.id.purpleCheckBox);
        CheckBox blackCheckBox = findViewById(R.id.blackCheckBox);
        CheckBox greyCheckBox = findViewById(R.id.greyCheckBox2);

        ArrayList<String> colorsSelected = new ArrayList<>();

        //Retrieving color selection/status from checkboxes
        boolean redStatus = redCheckBox.isChecked();
        boolean blueStatus = blueCheckBox.isChecked();
        boolean orangeStatus = orangeCheckBox.isChecked();
        boolean yellowStatus = yellowCheckBox.isChecked();
        boolean greenStatus = greenCheckBox.isChecked();
        boolean purpleStatus = purpleCheckBox.isChecked();
        boolean blackStatus = blackCheckBox.isChecked();
        boolean greyStatus = greyCheckBox.isChecked();

        if (true == redStatus)
        {
            colorsSelected.add("Red");
        }


        if (true == blueStatus)
        {
            colorsSelected.add("Blue");
        }


        if (true == orangeStatus)
        {
            colorsSelected.add("Orange");
        }


        if (true == yellowStatus)
        {
            colorsSelected.add("Yellow");
        }



        if (true == greenStatus)
        {
            colorsSelected.add("Green");
        }


        if (true == purpleStatus)
        {
            colorsSelected.add("Purple");
        }


        if (true == blackStatus)
        {
            colorsSelected.add("Black");
        }


        if (true == greyStatus)
        {
            colorsSelected.add("Grey");
        }


        CheckBox fallCheckBox = findViewById(R.id.fallCheckBox);
        CheckBox winterCheckBox = findViewById(R.id.winterCheckBox);
        CheckBox springCheckBox = findViewById(R.id.springCheckBox);
        CheckBox summerCheckBox = findViewById(R.id.summerCheckBox);

        ArrayList<String> seasons = new ArrayList<String>();
        boolean fallStatus = fallCheckBox.isChecked();
        boolean winterStatus = winterCheckBox.isChecked();
        boolean springStatus = springCheckBox.isChecked();
        boolean summerStatus = summerCheckBox.isChecked();


        if (true == fallStatus)
        {
            seasons.add("Fall");
        }

        if (true == winterStatus)
        {
            seasons.add("Winter");
        }

        if (true == springStatus)
        {
            seasons.add("Spring");
        }

        if (true == summerStatus)
        {
            seasons.add("Summer");
        }

        System.out.print("Adding Clothing Item, Hi");
        if (eventSource == R.id.addClothingItem_button)
        {

            Log.d("Add Clohting Item List", brand);
            Log.d("Add Clohting Item List", selectedMaterial);
            Log.d("Add Clohting Item List", selectedCategory);
            Log.d("Add Clohting Item List", colorsSelected.toString());
            Log.d("Add Clohting Item List", seasons.toString());
            ClothingItem newClothingItem = new ClothingItem(brand, selectedMaterial, selectedCategory,colorsSelected, seasons, size);

            wardrobe.addClothingItem(newClothingItem);

            Log.d("Add Clohting Item List", wardrobe.toString());

            finish();
        }
        else if (eventSource == R.id.takePicture_button)
        {
            //Log.d("Camera Button", "It was clicked!");
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            mCaptureImage.launch(takePictureIntent);
        }


    }

    private void setBackgroundColor(int color) {
        findViewById(R.id.add_clothing_activity).setBackgroundColor(getColor(color));
    }
}