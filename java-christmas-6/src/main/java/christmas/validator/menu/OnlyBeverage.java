package christmas.validator.menu;
import christmas.controller.preprocess.API;

import christmas.validator.RaiseExceptions;

import java.util.HashMap;
import java.util.List;

public class OnlyBeverage {
    RaiseExceptions Exceptions = new RaiseExceptions();
    API api = new API();
    Boolean isOnlyBeverage = true;
    HashMap catalog =  api.getCatalog();
    public void validate(List<String> requests) {
        catalog.forEach((name, type) -> {
            for(String order : requests)
                onlyBeverage(name, type, order);
        });
        Exceptions.beverage(isOnlyBeverage);
    }
    public void onlyBeverage(Object name, Object type, String order) {
        if (name.equals(order) && !type.equals("beverage"))
            isOnlyBeverage = false;
    }
}
