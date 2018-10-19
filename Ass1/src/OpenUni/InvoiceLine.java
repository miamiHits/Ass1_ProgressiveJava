package OpenUni;

import java.util.List;

public class InvoiceLine {

    private Item mItem;
    private int mCount;
    private double mTotalSum = 0;


    public InvoiceLine(Item mItem, int mCount) {
        this.mCount = mCount;
        this.mItem = mItem;
        calcTotalSum(mItem, mCount);

    }

    public Item getmItem() {
        return mItem;
    }

    public void setmItem(Item mItem) {
        this.mItem = mItem;
    }

    public int getmCount() {
        return mCount;
    }

    public double getmTotalSum() {
        return mTotalSum;
    }


    private void calcTotalSum(Item item, int count){
        this.mTotalSum = count * item.getmItemPrice();
    }

    public String printInvoiceLine(){
        return "Item Name: " + this.mItem.getmItemName() + " Item Count: " + this.mCount  + " Total Price : " + this.mTotalSum;
    }

}
