package OpenUni.Cash;

import java.util.ArrayList;
import java.util.List;

public class Cash {

    private double mCurrent_money;
    private List<InvoiceLine> mAllLines;

    public Cash (double curr_money) {
        this.mCurrent_money = curr_money;
        this.mAllLines = new ArrayList<>();
    }

    public Cash ( ) {
        this.mCurrent_money = 0;
        this.mAllLines = new ArrayList<>();
    }

    private double calcLeftOver(double givenMoney, double amountToPay){
        if (givenMoney < amountToPay) return -1;
        else if (givenMoney == amountToPay) return 0;
        else return  givenMoney - amountToPay;
    }

    public double getmCurrent_money() {
        return mCurrent_money;
    }

    /**
     * Adding the desired item to the invoice.
     * @param item (Item)
     * @param itemCount (int)
     */
    public void addItemToInvoice(Item item, int itemCount){
        //check if item already exists in the invoice. If yes - update it's count.
        for (InvoiceLine il: this.mAllLines)
        {
            if (il.getmItem().getmItemName().equals(item.getmItemName()))
            {
                int currentCount = il.getmCount() + itemCount;
                this.mAllLines.remove(il);
                itemCount = currentCount;
            }
        }
        InvoiceLine e = new InvoiceLine(item, itemCount);
        mAllLines.add(e);
    }

    /**
     * @return a string representation of the invoice.
     */

    public String getCurrTotalInvoice(){
        if (this.mAllLines.isEmpty())
            return "Invoice is empty ";

        StringBuffer invoice = new StringBuffer();
        for (InvoiceLine line : this.mAllLines){
            invoice.append(line.printInvoiceLine());
            invoice.append("\n");
        }

        return invoice.toString();
    }

    /**
     *
     * @return total sum of items in the invoice.
     */
    public double getTotalSum(){
        double totalSum = 0;
        for (InvoiceLine line : this.mAllLines){
            totalSum += line.getmTotalSum();
        }

        return totalSum;
    }

    /**
     *
     * @param givenMoney (int)
     * @return -1 - if pay action cannot be made. Otherwise - amount to return to the user in case he gave more money then needed.
     */
    public double pay(double givenMoney){
        if (this.mAllLines.isEmpty())
        {
            System.out.println("You didnt purchase nothing yet. Can't pay");
            return -1;
        }
        double amountToPay = getTotalSum();
        double amountToReturn =  calcLeftOver(givenMoney, amountToPay);
        if (amountToReturn == -1)
        {
            System.out.println("You didn't give enough money. Lets try again.");
            return -1;
        }
        if (this.mCurrent_money - amountToReturn < 0 )
        {
            System.out.println("Cash Is Out Of Money .... Cant give you all monet back. Go to change somewhere and come back. ");
            return -1;
        }else{
            this.mCurrent_money -= amountToReturn;
        }
        this.mAllLines.clear();

        return amountToReturn;

    }


}
