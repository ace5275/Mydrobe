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
import android.widget.ImageView;
import android.widget.Spinner;

public class AddClothingItemActivity extends AppCompatActivity implements View.OnClickListener
{
    Spinner clothingCategorySpinner, materialSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothing_item);

        clothingCategorySpinner = findViewById(R.id.clothingCategory_spinner);
        materialSpinner = findViewById(R.id.material_spinner);

        //ArrayAdapter is set up so that the spinner
        //displays the list of clothing types/catageories
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


        Intent returnIntent = new Intent();

//        String selectedCategory = (String) clothingCategorySpinner.getSelectedItem();
//        String selectedMaterial = (String) materialSpinner.getSelectedItem();
//
//        EditText sizeInput = findViewById(R.id.size_input);
//        String size = sizeInput.getText().toString();
//
//        CheckBox redCheckBox = findViewById(R.id.redCheckBox);
//        CheckBox blueCheckBox = findViewById(R.id.blueCheckBox);
//        CheckBox orangeCheckBox = findViewById(R.id.orangeCheckBox);
//        CheckBox yellowCheckBox = findViewById(R.id.yellowCheckBox);
//        CheckBox greenCheckBox = findViewById(R.id.greenCheckBox);
//        CheckBox purpleCheckBox = findViewById(R.id.purpleCheckBox);
//        CheckBox blackCheckBox = findViewById(R.id.blackCheckBox);
//        CheckBox greyCheckBox = findViewById(R.id.greyCheckBox2);
//
//        boolean redStatus = redCheckBox.isChecked();
//        boolean blueStatus = blueCheckBox.isChecked();
//        boolean orangeStatus = orangeCheckBox.isChecked();
//        boolean yellowStatus = yellowCheckBox.isChecked();
//        boolean greenStatus = greenCheckBox.isChecked();
//        boolean purpleStatus = purpleCheckBox.isChecked();
//        boolean blackStatus = blackCheckBox.isChecked();
//        boolean greyStatus = greyCheckBox.isChecked();

        if (eventSource == R.id.addClothingItem_button)
        {
            finish();
        }
        else if (eventSource == R.id.takePicture_button)
        {
            //Log.d("Camera Button", "It was clicked!");
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            mCaptureImage.launch(takePictureIntent);
        }
        else
        {
            Log.d("Camera Button", "It NOT was clicked!");
        }




        //returnIntent.put

        //finish();


    }
}