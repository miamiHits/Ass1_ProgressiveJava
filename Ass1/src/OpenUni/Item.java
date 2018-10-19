package OpenUni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item {
    private String mItemName;
    private double mItemPrice;
    private static HashMap<String, Double> mItems;

    public Item(String mItemName, double mItemPrice) {
        this.mItemPrice = mItemPrice;
        this.mItemName = mItemName;
        this.mItems = new HashMap<>();
    }

    public String getmItemName() {
        return mItemName;
    }

    public void setmItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public double getmItemPrice() {
        return mItemPrice;
    }

    public void setmItemPrice(Double mItemPrice) {
        this.mItemPrice = mItemPrice;
    }

    public static double getPriceByName(String itemName){
        return mItems.get(itemName);
    }
}
