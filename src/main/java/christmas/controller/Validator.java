package christmas.controller;

import christmas.model.Errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final String IS_ONLY_NUMBER = "[0-9]+";
    private static List<String> duplicate = new ArrayList<>();
    int total = 0;
    Boolean isOnlyBeverage = true;

    public int isDayValid(String day) {
        if (isInteger(day) && isRangeValid(day))
            return Integer.parseInt(day);
        throw new IllegalArgumentException(Errors.DAY.getMessage());
    }
    public boolean isInteger(String number) {
        return number.matches(IS_ONLY_NUMBER);
    }
    public boolean isRangeValid(String number) {
        int parsed = Integer.parseInt(number);
        return 1 <= parsed && parsed <= 31;
    }
    public String[] isFormatValid(String[] format) {
        if (format.length != 2)
            throw new IllegalArgumentException(Errors.MENU.getMessage());
        return format;
    }
    public String[] isMenuValid(String[] format, List<String> catalog) {
        isNameValid(format[0]);
        if(containMenu(format[0], catalog) && isInteger(format[1])) {
            duplicate.add(format[0]);
            total += Integer.parseInt(format[1]);
            twenty();
            return format;
        }
        throw new IllegalArgumentException(Errors.MENU.getMessage());
    }
    public void isNameValid(String name) {
        if (duplicate.contains(name))
            throw new IllegalArgumentException(Errors.MENU.getMessage());
    }
    public Boolean containMenu(String name, List<String> catalog) {
        return catalog.contains(name);
    }

    public void isOrderValid(HashMap catalog, List<String> order) {
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
