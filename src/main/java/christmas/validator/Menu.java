package christmas.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    int total = 0;
    Boolean isOnlyBeverage = true;
    Common common = new Common();

    public String[] format(String[] format) {
        if (format.length != 2)
            throw new IllegalArgumentException(Errors.MENU.getMessage());
        return format;
    }
    public String[] menu(String[] format, List<String> catalog, List<String> duplicate) {
        name(format[0], duplicate);
        if(matching(format[0], catalog) && common.isInteger(format[1])) {
            duplicate.add(format[0]);
            total += Integer.parseInt(format[1]);
            twenty();
            return format;
        }
        throw new IllegalArgumentException(Errors.MENU.getMessage());
    }
    public void name(String name,List<String> duplicate) {
        if (duplicate.contains(name)) {
            throw new IllegalArgumentException(Errors.MENU.getMessage());
        }

    }
    public Boolean matching(String name, List<String> catalog) {
        return catalog.contains(name);
    }
    public void order(HashMap catalog, List<String> order) {
        catalog.forEach((name, type) -> {
            for(String menu : order) {
                match(name, type, menu);
            }
        });
        beverage();
    }
    public void match(Object name, Object type, String menu) {
        if (name.equals(menu) && !type.equals("beverage")) {
            isOnlyBeverage = false;
        }
    }
    public void twenty(){
        if (total > 20)
            throw new IllegalArgumentException(Errors.TWENTY.getMessage());
    }
    public void beverage(){
        if (isOnlyBeverage)
            throw new IllegalArgumentException(Errors.NOT_ONLY.getMessage());
    }
}
