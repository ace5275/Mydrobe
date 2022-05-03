package edu.psu.ist.mydrobe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import java.util.ArrayList;

public class ClothingListAdapter extends ArrayAdapter<ClothingItem>
{
    private static final Object RESULT_OK = 200;
    private Context mContext;
    int mResource;
    private static final String TAG = "ClothingListAdapter";

    public ClothingListAdapter(Context mContext, int mResource, Wardrobe wardrobe)
    {

        //Log.d("ClothingLA", "ClothingListLA");
        super(mContext, mResource, wardrobe.getOriginalWardobe());
        this.mContext = mContext;
        this.mResource = mResource;
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent)
    {
        String brand = getItem(position).getBrand();
        String category = getItem(position).getCategory();
        Double size = getItem(position).getSize();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView brandView = (TextView)  convertView.findViewById(R.id.textView3);
        TextView categoryView = (TextView)  convertView.findViewById(R.id.textView4);
        RadioButton selectedClothingItemRB = convertView.findViewById(R.id.radioButton);

//        selectedClothingItemRB.setOnClickListener(this);


        Wardrobe wardrobe = new Wardrobe();
        ArrayList<ClothingItem> clothingItemsArray = wardrobe.getOriginalWardobe();


        brandView.setText("Brand: " + brand);
        categoryView.setText(category + ", Size " + size);


        return convertView;
    }


//    @Override
//    public void onClick(View view, Activity mActivity) {
//
//        int position = (Integer) view.getTag();
//        ClothingItem selectedClothingItem = getItem(position);
//
//        Intent ClothingItemIntent = new Intent();
//        ClothingItemIntent.putExtra("New Selected Outfit", selectedClothingItem.toString());
//
//        setResult(RESULT_OK, ClothingItemIntent);
//        finish();
//
//
//    }


}
