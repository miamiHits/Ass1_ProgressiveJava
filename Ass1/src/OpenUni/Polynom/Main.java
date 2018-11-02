package OpenUni.Polynom;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Polynomial p1;
        Polynomial p2;
        String [] p1_vector;
        String [] p2_vector;
        String line;

        System.out.println("Enter 1st Polynomial- by pairs of coef and exp. For example: 2,3 4,5 will be: 4.0X^5 + 2.0X^3");
        line = sc.nextLine();
        p1_vector = line.split("\\s+");
        p1 = buildPolyFromUserInput(p1_vector);
        System.out.println("1st Polynomial is (P1): " + p1.toString());
        System.out.println("Enter 2nd Polynomial. Remember: pairs of coef and exp.");
        line = sc.nextLine();
        p2_vector = line.split("\\s+");
        p2 = buildPolyFromUserInput(p2_vector);
        System.out.println("2nd Polynomial is (P2): " + p2.toString());
        System.out.println("\n");
        Polynomial p3 = p1.plus(p2);

        System.out.println("P1+P2 =  " + p3.toString());
        System.out.println("\n");
        System.out.println("P1-P2 =  " + p1.minus(p2).toString());
        System.out.println("P2-P1 =  " + p2.minus(p1).toString());
        System.out.println("\n");
        System.out.println("P1 derivative =  " + p1.derive().toString());
        System.out.println("P2 derivative =  " + p2.derive().toString());
        System.out.println("\n");
        System.out.println("Who is more bigger? let's check that issue ...");
        if (p1.compareTo(p2) == 1) {
            System.out.println(" P1 ");
        }
        else if (p1.compareTo(p2) == -1) {
            System.out.println(" P2 ");
        }
        else if (p1.compareTo(p2) == 0){
            System.out.println("Same higher degree ...");
        }


    }

    private static Polynomial buildPolyFromUserInput(String[] p1_vector) {
        ArrayList resPoly = new ArrayList<Item>();
        for(String pair : p1_vector)
        {
            resPoly.add(new Item(Integer.parseInt(pair.split(",")[1]), Double.parseDouble(pair.split(",")[0])));
        }

        return new Polynomial(resPoly);
    }


}
