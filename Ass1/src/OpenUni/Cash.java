package OpenUni;

import java.util.ArrayList;
import java.util.List;

public class Cash {

    private double mCurrent_money = 0;
    private List<InvoiceLine> mAllLines;

    public Cash (double curr_money) {
        this.mCurrent_money = curr_money;
        this.mAllLines = new ArrayList<>();
    }

    public Cash ( ) {
        this.mAllLines = new ArrayList<>();
    }

    public void addItemToInvoice(Item item, int itemCount){
        InvoiceLine e = new InvoiceLine(item, itemCount);
        mAllLines.add(e);
    }





}
