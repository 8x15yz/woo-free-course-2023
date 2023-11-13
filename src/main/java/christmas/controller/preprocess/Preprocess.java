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

    public HashMap part(String input) {
        HashMap<String, Integer> requests = clean(input);
        beverage.validate(new ArrayList<>(requests.keySet()));
        count.validate(new ArrayList<>(requests.values()));
        return requests;
    }
    public HashMap clean(String input) {
        List<String> alreadyOrderd= new ArrayList<>();
        HashMap<String, Integer> requests = new HashMap<>();

        for (String menu : input.split(",")) {
            String[] cleanData = divide(menu, alreadyOrderd);
            requests.put( cleanData[0], Integer.valueOf(cleanData[1]));
        }
        return requests;
    }
    public String[] divide(String order, List<String> duplicate) {
        String[] divided = format.validate(String.valueOf(order).split("-"));
        menu.validate(divided[0], duplicate);
        count.isInt(divided[1]);
        return divided;
     }
}
