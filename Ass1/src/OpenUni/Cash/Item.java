package OpenUni.Cash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item {
    private String mItemName;
    private double mItemPrice;

    private static HashMap<String, Double> mItems = new HashMap<>();
    private static List<Item> mItemsList = new ArrayList<>();

    public Item(String mItemName, double mItemPrice) {
        this.mItemPrice = mItemPrice;
        this.mItemName = mItemName;
        this.mItems.put(mItemName, mItemPrice);
        this.mItemsList.add(this);
    }

    public String getmItemName() {
        return mItemName;
    }

    public double getmItemPrice() {
        return mItemPrice;
    }

    public static double getPriceByName(String itemName){
        return mItems.get(itemName);
    }


    public List<Item> getmItemsList() {
        return mItemsList;
    }

    public static HashMap<String, Double> getmItems() {
        return mItems;
    }

    public static Item getItemByName(String name)
    {
        for(Item t : mItemsList)
        {
            if (t.getmItemName().equals(name))
                return t;
        }

        return null;
    }
}
