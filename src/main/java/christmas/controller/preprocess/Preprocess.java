package christmas.controller.preprocess;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import christmas.validator.menu.OnlyBeverage;
import christmas.validator.menu.OrderMenu;
import christmas.validator.menu.OrderCount;
import christmas.validator.menu.Format;
public class Preprocess {
    OrderMenu menu = new OrderMenu();
    OrderCount count = new OrderCount();
    Format format = new Format();
    OnlyBeverage beverage = new OnlyBeverage();
    api api = new api();

    public HashMap part(String input) {
        HashMap<String, Integer> response = clean(input);
        beverage.validate(new ArrayList<>(response.keySet()));
        count.validate(new ArrayList<>(response.values()));
        return response;
    }
    public HashMap clean(String input) {
        List<String> duplicate= new ArrayList<>();
        HashMap<String, Integer> requests = new HashMap<>();
        List<String> catalog = api.getMenus();

        for (String menu : input.split(",")) {
            String[] cleanData = divide(menu, duplicate, catalog);
            requests.put(cleanData[0], Integer.valueOf(cleanData[1]));
        }
        return requests;
    }
    public String[] divide(String order, List duplicate, List catalog) {
        String[] divided = format.validate(String.valueOf(order).split("-"));
        menu.validate(divided[0], duplicate, catalog);
        count.isInteger(divided[1]);
        return divided;
     }
}
