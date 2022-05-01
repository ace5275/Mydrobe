package edu.psu.ist.mydrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ClothingListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Wardrobe wardrobe = new Wardrobe();


        ArrayList<String> colors = new ArrayList<>();
            colors.add("Blue");
        ArrayList<String> seasons = new ArrayList<>();
        colors.add("Winter");
        ClothingItem item = new ClothingItem("Forever21", "Silk", "Shirt", colors, seasons, 5.0);
        ClothingItem item2 = new ClothingItem("H&m", "Silk", "Shirt", colors, seasons, 5.0);
        ClothingItem item3 = new ClothingItem("Shein", "Silk", "Shirt", colors, seasons, 5.0);
        wardrobe.addClothingItem(item);
        wardrobe.addClothingItem(item2);
        wardrobe.addClothingItem(item3);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_list);

        ListView mListView = (ListView) findViewById(R.id.clothingListView);

        ClothingListAdapter adapter = new ClothingListAdapter(this, R.layout.clothing_item_layout, wardrobe);
        mListView.setAdapter(adapter);
    }
}