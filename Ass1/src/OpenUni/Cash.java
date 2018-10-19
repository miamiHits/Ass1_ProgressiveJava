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

    private double calcLeftOver(double givenMoney, double amountToPay){
        if (givenMoney < amountToPay) return -1;
        else if (givenMoney == amountToPay) return 0;
        else return amountToPay - givenMoney;
    }

    public void addItemToInvoice(Item item, int itemCount){
        InvoiceLine e = new InvoiceLine(item, itemCount);
        mAllLines.add(e);
    }

    public String getCurrTotalInvoice(){
        StringBuffer invoice = new StringBuffer();
        for (InvoiceLine line : this.mAllLines){
            invoice.append(line.printInvoiceLine());
        }

        return invoice.toString();
    }

    public double getTotalSum(){
        double totalSum = 0;
        for (InvoiceLine line : this.mAllLines){
            totalSum += line.getmTotalSum();
        }

        return totalSum;
    }

    public double pay(double givenMoney){
        double amountToPay = getTotalSum();
        double amountToReturn =  calcLeftOver(givenMoney, amountToPay);
        this.mCurrent_money -= amountToReturn;
        if (this.mCurrent_money < 0 )
            System.out.println("Cash Is Out Of Money .... ");

        return amountToReturn;

    }

    public double getmCurrent_money() {
        return mCurrent_money;
    }




}
