package edu.psu.ist.mydrobe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClothingListAdapter extends ArrayAdapter<ClothingItem>
{
    private Context mContext;
    int mResource;

    public ClothingListAdapter(Context mContext, int mResource, Wardrobe wardrobe)
    {

        //Log.d("ClothingLA", "ClothingListLA");
        super(mContext, mResource, wardrobe.getOriginalWardobe());
        this.mContext = mContext;
        this.mResource = mResource;

        System.out.print("Clothing LA");
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent)
    {
        String brand = getItem(position).getBrand();
        String category = getItem(position).getCategory();


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView brandView = (TextView)  convertView.findViewById(R.id.textView3);
        TextView sizeView = (TextView)  convertView.findViewById(R.id.textView4);

        Wardrobe wardrobe = new Wardrobe();
        ArrayList<ClothingItem> clothingItemsArray = wardrobe.getOriginalWardobe();
//        for (int i =0; i < clothingItemsArray.size();i++)
//        {
//            brandView.setText(clothingItemsArray.get(i).getBrand());
//            sizeView.setText(clothingItemsArray.get(i).getCategory());
//        }
        brandView.setText(brand);
        sizeView.setText(category);

        //        ImageView clothingImage = (ImageView) convertView.findViewById(R.id.imageView);
//
//        txtView1.setText("Hello");
//        txtView2.setText("Is this working?");
//
////          String brand = getItem(position).getBrand();
////        double size = getItem(position).getSize();
////        String material = getItem
////
////        ClothingItem clothingItem = new ClothingItem(brand, selectedMaterial, selectedCategory,colorsSelected, seasons, size);
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        convertView = inflater.inflate(mResource, parent, false);
//
////        TextView tvName = (T)

        return convertView;
    }
}
