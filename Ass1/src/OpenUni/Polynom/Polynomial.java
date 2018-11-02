package OpenUni.Polynom;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Polynomial {

    private ArrayList<Item> mPoly ;
    private ExponentComparator mCompare = new ExponentComparator();

    public Polynomial(int [] exp, double [] coeff) {
        if (exp.length >= 2) sortDesOrder(exp);
        this.mPoly = createPoly(exp, coeff);

        //Just to nake sure it's sorted
        this.mPoly.sort(mCompare);
    }

    public Polynomial(ArrayList<Item> resPoly) {
        mPoly = new ArrayList<>();
        for (Item i : resPoly) {
            if (i.getCoef()!=0) mPoly.add(new Item(i.getExp(), i.getCoef()));
        }
        mPoly.sort(mCompare);
    }

    private void sortDesOrder(int[] exp) {
        Arrays.sort(exp);
        IntStream.range(0, exp.length / 2).forEach(i -> {
            int temp = exp[i];
            exp[i] = exp[exp.length - i - 1];
            exp[exp.length - i - 1] = temp;
        });
    }

    private ArrayList createPoly(int[] exp, double[] coeff) {
        ArrayList p = IntStream.range(0, exp.length).filter(i -> coeff[i] != 0).mapToObj(i -> new Item(exp[i], coeff[i]))
                .collect(Collectors.toCollection((Supplier<ArrayList>) ArrayList::new));
        return p;
    }

    public ArrayList<Item> getmPoly() {
        return mPoly;
    }

    /**
     * @return the highest degree of the Polynomial - it'll be placed at 0 index
     */
    public int get_degree(){
        return this.mPoly.get(0).getExp();
    }

    /**
     *
     * @param degree of given Polynomial
     * @return coefficient of this degree at the Polynomial
     */
    public double getCoefficientAtDegree(int degree) {
        return this.mPoly.stream().filter(i -> i.getExp() == degree).findFirst().map(Item::getCoef).orElse(0.0);
    }

    /**
     *
     * @param q - Other Polynomial
     * @return The result from adding between this Polynomial and q Polynomial
     */
    public Polynomial plus(Polynomial q) {
        ArrayList<Item> resPoly;
        int maxDeg = Math.max(this.get_degree(), q.get_degree());
        resPoly = IntStream.rangeClosed(0, maxDeg).mapToObj(i -> new Item(i, this.getCoefficientAtDegree(i) + q.getCoefficientAtDegree(i)))
                .collect(Collectors.toCollection(ArrayList::new));
        return new Polynomial(resPoly);
    }

    /**
     *
     * @param q - Other Polynomial
     * @return The result from subtraction between this Polynomial and q Polynomial
     */
    public Polynomial minus(Polynomial q) {
        ArrayList<Item> resPoly;
        int maxDeg = Math.max(this.get_degree(), q.get_degree());
        resPoly = IntStream.rangeClosed(0, maxDeg).mapToObj(i -> new Item(i, this.getCoefficientAtDegree(i) - q.getCoefficientAtDegree(i)))
                .collect(Collectors.toCollection(ArrayList::new));
        return new Polynomial(resPoly);
    }

    /**
     *
     * @return the derive of this Polynomial
     */
    public Polynomial derive() {
        ArrayList<Item> resPoly = new ArrayList<Item>();
        this.mPoly.forEach(i -> {
            int exp = i.getExp();
            double coef = i.getCoef();
            if (exp >= 1) {
                resPoly.add(new Item(exp - 1, coef * exp));
            }
        });
        return new Polynomial(resPoly);
    }

    /**
     *
     * @return String representation of the Polynomial
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (Item i : this.mPoly) {
            int exp = i.getExp();
            double coef = i.getCoef();
            if (coef > 0 && !isFirst) {
                sb.append(" + ");
            }
            isFirst = false;
            sb.append(coef);
            if (exp > 0) {
                sb.append("X");
            }
            if (exp > 1) {
                sb.append("^");
                sb.append(exp);
            }
        }
        return sb.toString();
    }

    /**
     * Will check who is bigger. By subtract other Polynomial from this Polynomial.
     * If we got coef greater then 0 then this Polynomial has bigger coef so from lean to infinity he's Won:)
     * Same to opposite case.
     * if the results of the subtraction is 0 then both Polynomials from lean to infinity are equal.
     * @param other (Polynomial)
     * @return 1 if this is bigger. -1 if this is smaller. 0 if both are equals.
     */
    public int compareTo(Polynomial other) {
        Polynomial res = this.minus(other);
        if (res.getmPoly().isEmpty()) return 0;
        for (Item i: res.getmPoly()){
            if (i.getCoef() > 0 ) return 1;
            else if (i.getCoef() < 0 ) return -1;

        }

        return 0;
    }






}



