package edu.psu.ist.mydrobe;

import java.util.ArrayList;

public class Wardrobe
{
    private static ArrayList<ClothingItem> originalWardobe = new ArrayList<>();

    public Wardrobe(ArrayList<ClothingItem> originalWardobe)
    {
        this.originalWardobe = originalWardobe;
    }

    public Wardrobe()
    {

    }

    public void addClothingItem(ClothingItem newClothingItem)
    {
        originalWardobe.add(newClothingItem);
    }

    public ArrayList<ClothingItem> getOriginalWardobe()
    {
        return originalWardobe;
    }

    public void setOriginalWardobe(ArrayList<ClothingItem> originalWardobe) {
        this.originalWardobe = originalWardobe;
    }

    @Override
    public String toString() {
        return "Wardrobe{" +
                "originalWardobe=" + originalWardobe +
                '}';
    }
}
