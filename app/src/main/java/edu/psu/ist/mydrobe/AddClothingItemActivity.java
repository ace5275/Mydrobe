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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddClothingItemActivity extends AppCompatActivity implements View.OnClickListener
{
    Spinner clothingCategorySpinner, materialSpinner;
    Wardrobe wardrobe;

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

        findViewById(R.id.takePicture_button).setOnClickListener(this);

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

        Intent intent = new Intent();

        //Retrieving selected clothing type
        String selectedCategory = (String) clothingCategorySpinner.getSelectedItem();

        //Retrieving selected material type
        String selectedMaterial = (String) materialSpinner.getSelectedItem();

        //Retrieving size input
        EditText sizeInput = findViewById(R.id.size_input);
        double size = Double.parseDouble(sizeInput.getText().toString());

        EditText brandInput = findViewById(R.id.brand_input);
        String brand = brandInput.getText().toString();

        //Retrieving color selection
        CheckBox redCheckBox = findViewById(R.id.redCheckBox);
        CheckBox blueCheckBox = findViewById(R.id.blueCheckBox);
        CheckBox orangeCheckBox = findViewById(R.id.orangeCheckBox);
        CheckBox yellowCheckBox = findViewById(R.id.yellowCheckBox);
        CheckBox greenCheckBox = findViewById(R.id.greenCheckBox);
        CheckBox purpleCheckBox = findViewById(R.id.purpleCheckBox);
        CheckBox blackCheckBox = findViewById(R.id.blackCheckBox);
        CheckBox greyCheckBox = findViewById(R.id.greyCheckBox2);

        ArrayList<String> colorsSelected = new ArrayList<>();

        boolean redStatus = redCheckBox.isChecked();
        if (true == redStatus)
        {
            colorsSelected.add("Red");
        }

        boolean blueStatus = blueCheckBox.isChecked();
        if (true == blueStatus)
        {
            colorsSelected.add("Blue");
        }

        boolean orangeStatus = orangeCheckBox.isChecked();
        if (true == orangeStatus)
        {
            colorsSelected.add("Orange");
        }

        boolean yellowStatus = yellowCheckBox.isChecked();
        if (true == yellowStatus)
        {
            colorsSelected.add("Yellow");
        }


        boolean greenStatus = greenCheckBox.isChecked();
        if (true == greenStatus)
        {
            colorsSelected.add("Green");
        }

        boolean purpleStatus = purpleCheckBox.isChecked();
        if (true == purpleStatus)
        {
            colorsSelected.add("Purple");
        }
        boolean blackStatus = blackCheckBox.isChecked();
        if (true == blackStatus)
        {
            colorsSelected.add("Black");
        }

        boolean greyStatus = greyCheckBox.isChecked();
        if (true == greyStatus)
        {
            colorsSelected.add("Grey");
        }


        CheckBox fallCheckBox = findViewById(R.id.fallCheckBox);
        CheckBox winterCheckBox = findViewById(R.id.winterCheckBox);
        CheckBox springCheckBox = findViewById(R.id.springCheckBox);
        CheckBox summerCheckBox = findViewById(R.id.summerCheckBox);

        boolean fallStatus = fallCheckBox.isChecked();
        boolean winterStatus = winterCheckBox.isChecked();
        boolean springStatus = springCheckBox.isChecked();
        boolean summerStatus = summerCheckBox.isChecked();
        ArrayList<String> seasons = new ArrayList<String>();

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

        if (eventSource == R.id.addClothingItem_button)
        {
            ClothingItem newClothingItem = new ClothingItem(brand, selectedMaterial, selectedCategory,colorsSelected, seasons, size);
            wardrobe.add(new ClothingItem);

            System.out.print(wardrobe);

            finish();
        }
        else if (eventSource == R.id.takePicture_button)
        {
            //Log.d("Camera Button", "It was clicked!");
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            mCaptureImage.launch(takePictureIntent);
        }




        //returnIntent.put

        //finish();


    }
}