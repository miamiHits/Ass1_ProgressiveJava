package OpenUni.Cash;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Item book1 = new Item("Harry_Potter", 100);
        Item book2 = new Item("Harry_Potter2", 120);
        Item book3 = new Item("Harry_Potter3", 200);
        Item pen = new Item("Pen", 2.5);

        System.out.print("All items are: " + Item.getmItems().toString());
        System.out.println();
        Cash cash = new Cash(500);

        cash.addItemToInvoice(book1, 1);
        cash.addItemToInvoice(pen, 3);
        System.out.println("!!! WELCOME TO YARDEN C STORE !!!");
        String menu = "Enter your choice:\n" +
                " 1 - Get your invoice.\n" +
                " 2 - Get your total sum of purchase.\n" +
                " 3 - Pay.\n" +
                " 4 - Get amount of money in the cash register .\n " +
                " 5 - Add item to invoice .\n " +
                "6 - Exit System . \n";

        System.out.print(menu);

        int choise = sc.nextInt();
        while (choise != 6){
            switch (choise){
                case(1):
                    System.out.println("Your Invoice is: ");
                    System.out.println(cash.getCurrTotalInvoice());
                    break;

                case(2):
                    System.out.println(cash.getTotalSum());
                    break;

                case(3):
                    System.out.println("Please enter with how much money you want to pay: ");
                    double amountToPay = sc.nextDouble();
                    System.out.println(cash.pay(amountToPay));
                    break;

                case(4):
                    System.out.println(cash.getmCurrent_money());
                    break;

                case (5):
                    System.out.println("Please enter product name:");
                    String item = sc.next();
                    if (!Item.getmItems().containsKey(item)) {
                        System.out.println("Unrecognized item name: " + item);
                    }
                    else {
                        System.out.println("please enter number of items you wish to buy from " + item);
                        int amount = sc.nextInt();
                        Item desired_item = Item.getItemByName(item);
                        cash.addItemToInvoice(desired_item, amount);
                    }
                    break;
                default:
                    System.out.println("Wrong choise.. lets try again. Enter ");
            }

            System.out.println("-- You didnt ask to exit, so we'll start over again -- ");
            System.out.println(menu);
            choise = sc.nextInt();
        }

        System.out.println("Bye Bye");
        System.exit(0);




    }
}
