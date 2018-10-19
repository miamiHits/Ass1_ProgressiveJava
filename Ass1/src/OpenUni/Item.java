package OpenUni;
import java.util.HashMap;

public class Item {
    private String mItemName;
    private double mItemPrice;
    public static HashMap<String, Double> mItems = new HashMap<>();

    public Item(String mItemName, double mItemPrice) {
        this.mItemPrice = mItemPrice;
        this.mItemName = mItemName;
        this.mItems.put(mItemName, mItemPrice);
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
