package christmas.validator.menu;
import christmas.controller.preprocess.api;

import christmas.validator.RaiseExceptions;

import java.util.List;

public class OrderMenu {
    RaiseExceptions Exceptions = new RaiseExceptions();
    api api = new api();
    private List<String> catalog = api.getMenus();
    public void validate(String name, List<String> alreadyOrderd) {
        Exceptions.duplicate(alreadyOrderd.contains(name));
        Exceptions.matching(!(catalog.contains(name)));

        alreadyOrderd.add(name);
    }
}
