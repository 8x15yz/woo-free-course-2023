package christmas.controller.preprocess;

import christmas.model.Menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class API {
    Menus[] values = Menus.values();
    public HashMap getCatalog() {
        HashMap<String, String> catalog = new HashMap<>();
        for (Menus value : values) {
            String[] menu = value.getCatalog();
            String name = menu[0];
            String type = menu[1];

            catalog.put(name, type);
        }
        return catalog;
    }
    public List<String> getMenus() {
        List<String> menus = new ArrayList<>();
        for (Menus value : values)
            menus.add(value.getName());
        return menus;
    }
}
