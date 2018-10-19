package OpenUni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cash {

    private double mcurrent_money = 0;
    private Map<String, Integer> mitems;
    private List<String> mInvoice;
    public Cash (double curr_money) {
        this.mcurrent_money = curr_money;
        this.mitems = new HashMap<>();
        this.mInvoice = new ArrayList<>();
    }

    public Cash ( ) {
        this.mitems = new HashMap<>();
        this.mInvoice = new ArrayList<>();
    }

    public void addItemToInvoice(String itemName, int itemCount){
        this.mitems.put(itemName, itemCount);
        this.mInvoice.add("Item: " + itemName + "Item Count: " + itemCount);
    }





}
