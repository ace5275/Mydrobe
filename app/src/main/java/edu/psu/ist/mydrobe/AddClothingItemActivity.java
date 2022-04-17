package edu.psu.ist.mydrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddClothingItemActivity extends AppCompatActivity
{
    Spinner clothingCategorySpinner, materialSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothing_item);

        clothingCategorySpinner = findViewById(R.id.clothingCategory_spinner);
        materialSpinner = findViewById(R.id.material_spinner);

        ArrayAdapter<CharSequence> clothingCategoryAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.clothing_categories,
                        android.R.layout.simple_spinner_item);
        clothingCategoryAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> materialAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.materials,
                        android.R.layout.simple_spinner_item);
        materialAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        clothingCategorySpinner.setAdapter(clothingCategoryAdapter);
        materialSpinner.setAdapter(materialAdapter);

    }
}