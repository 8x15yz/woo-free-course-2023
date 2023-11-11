package christmas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import christmas.controller.Validator;
import christmas.controller.Reserve;
import christmas.model.Errors;
import christmas.model.Menus;

public class Preprocess {
    Validator validator = new Validator();
    Reserve reserve = new Reserve();

    public HashMap individually(String input) {
        HashMap<String, String> catalogs = reserve.getCatalog();
        List<String> catalog = new ArrayList<>(catalogs.keySet());
        HashMap<String, Integer> orders = new HashMap<>();

        for (String menu : input.split(",")) {
            String[] cleand = divide(menu, catalog);
            orders.put(cleand[0], Integer.valueOf(cleand[1]));
        }

        List<String> order = new ArrayList<>(orders.keySet());
        validator.isOrderValid(catalogs, order);
        return orders;
    }
    public String[] divide(String menu, List<String> catalog) {
        String[] format = String.valueOf(menu).split("-");
        return validator.isMenuValid(
                validator.isFormatValid(format), catalog
        );
    }
}
