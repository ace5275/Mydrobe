/**
 * ClothingItem.java
 * Version 4.14.2022
 * Description: This class represents a clothing item
 * a user owns.
 */

package edu.psu.ist.mydrobe;

import java.util.ArrayList;

public class ClothingItem
{
    private String brand, material, category, patternType;
    private ArrayList<String> color, season;
    private double size;
    private int clothingImageID;

    private static ArrayList<ClothingItem> wardrobe;

    public ClothingItem(String brand, String material, String category, String patternType, ArrayList<String> color,
                        ArrayList<String> season, double size, int clothingImageID)
    {
        this.brand = brand;
        this.material = material;
        this.category = category;
        this.patternType = patternType;
        this.color = color;
        this.season = season;
        this.size = size;
        this.clothingImageID = clothingImageID;

        //addClothingItemToList();
    }

    public ClothingItem(String brand, String material, String category, ArrayList<String> color,
                        ArrayList<String> season, double size)
    {
        this.brand = brand;
        this.material = material;
        this.category = category;
        this.patternType = patternType;
        this.color = color;
        this.season = season;
        this.size = size;

        //addClothingItemToList();
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getMaterial()
    {
        return material;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getPatternType()
    {
        return patternType;
    }

    public void setPatternType(String patternType)
    {
        this.patternType = patternType;
    }

    public ArrayList<String> getColor()
    {
        return color;
    }

    public void setColor(ArrayList<String> color)
    {
        this.color = color;
    }

    public ArrayList<String> getSeason()
    {
        return season;
    }

    public void setSeason(ArrayList<String> season)
    {
        this.season = season;
    }

    public double getSize()
    {
        return size;
    }

    public void setSize(double size)
    {
        this.size = size;
    }

    public int getClothingImageID()
    {
        return clothingImageID;
    }

    public void setClothingImageID(int clothingImageID)
    {
        this.clothingImageID = clothingImageID;
    }

    public void addClothingItemToList(ClothingItem newClothingItem)
    {
        wardrobe.add(newClothingItem);
    }
    public ArrayList<ClothingItem> getWardrobe()
    {
        return wardrobe;
    }

    public void setWardrobe(ArrayList<ClothingItem> wardrobe)
    {
        this.wardrobe = wardrobe;
    }
}