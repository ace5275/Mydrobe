/**
 * Outfit.java
 * Version 4.14.2022
 * Description: This class represents an outfit
 * that contains clothing items.
 */

package edu.psu.ist.mydrobe;

import java.util.ArrayList;

public class Outfit
{
    String nameOfOutfit;
    ArrayList<ClothingItem> clothingItems;

    public Outfit(String nameOfOutfit, ArrayList<ClothingItem> clothingItems)
    {
        this.nameOfOutfit = nameOfOutfit;
        this.clothingItems = clothingItems;
    }

    public String getNameOfOutfit()
    {
        return nameOfOutfit;
    }

    public void setNameOfOutfit(String nameOfOutfit)
    {
        this.nameOfOutfit = nameOfOutfit;
    }

    public ArrayList<ClothingItem> getClothingItems()
    {
        return clothingItems;
    }

    public void setClothingItems(ArrayList<ClothingItem> clothingItems)
    {
        this.clothingItems = clothingItems;
    }

    public void addClothingItem(ClothingItem addedClothingItem)
    {
        clothingItems.add(addedClothingItem);
    }

    public void deleteClothingItem(ClothingItem removedClothingItem)
    {
        clothingItems.remove(removedClothingItem);
    }
}
