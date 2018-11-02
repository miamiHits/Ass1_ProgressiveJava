package OpenUni.Polynom;

import java.util.Comparator;

public class ExponentComparator implements Comparator<Item> {

    @Override
    public int compare(Item t1, Item t2) {
        if (t1.getExp() > t2.getExp()) {
            return -1;
        }
        else {
            if (t1.getExp() < t2.getExp()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
