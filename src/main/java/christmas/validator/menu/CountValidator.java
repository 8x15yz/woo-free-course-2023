package christmas.validator.menu;
import java.util.ArrayList;

import christmas.validator.Common;
import christmas.validator.RaiseExceptions;

public class CountValidator {

    Common common = new Common();
    RaiseExceptions Exception = new RaiseExceptions();
    public void isInteger(String num) {
        Exception.number(!(common.isInteger(num)));
    }
    public void validate(ArrayList<Integer> order){
        int total = 0;
        for (Integer a : order)
            total += a;
        Exception.overOrder(total > 20);
    }
}
