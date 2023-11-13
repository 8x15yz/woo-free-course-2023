package christmas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import christmas.validator.Menu;
public class Preprocess {
    Menu validator = new Menu();
    Reserve reserve = new Reserve();

    public HashMap part(String input) {
        HashMap catalog = reserve.getCatalog();
        HashMap<String, Integer> orders = new HashMap<>();
        validator.order(
                catalog,
                new ArrayList<>(clean(input, catalog, orders).keySet())
        );
        return orders;
    }
    public HashMap clean (String input, HashMap catalog, HashMap orders) {
        List<String> menuNames = new ArrayList<>(catalog.keySet());
        List<String> duplicate = new ArrayList<>();
        for (String menu : input.split(",")) {
            String[] cleanData = divide(menu, menuNames, duplicate);
            orders.put(
                    cleanData[0],
                    Integer.valueOf(cleanData[1])
            );
        }
        return orders;
    }
    public String[] divide(String order, List<String> catalog,List<String> duplicate) {
        String[] format = String.valueOf(order).split("-");

        return validator.menu(
                validator.format(format),
                catalog,
                duplicate
        );
    }

}
