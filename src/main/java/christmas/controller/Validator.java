package christmas.controller;

import christmas.model.Errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validator {
    private static final String IS_ONLY_NUMBER = "[0-9]+";

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

    public HashMap isMenuValid(String input, List<String> catalog) {
        HashMap<String, Integer> orders = new HashMap<>();
        for (String menu : input.split(",")) {
            String[] cleand = isFormatValid(menu, catalog);
            orders.put(cleand[0], Integer.valueOf(cleand[1]));
        }
        System.out.println(orders);
        return orders;
    }
    public String[] isFormatValid(String menu, List<String> catalog) {
        String[] format = String.valueOf(menu).split("-");
        if(containMenu(format[0], catalog) && isInteger(format[1])) {
            return format;
        }
        throw new IllegalArgumentException(Errors.MENU.getMessage());
    }

    public Boolean containMenu(String name, List<String> catalog) {
        return catalog.contains(name);
    }
    public void isOrderValid(HashMap catalog, List order) {
        int total = 0;
        List<String> names = new ArrayList<>();
        List<String> types = new ArrayList<>();
        duplicate();
        twenty();
        beverage();
    }
    public void duplicate(){}
    public void twenty(){}
    public void beverage(){}
}
