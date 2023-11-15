package christmas.validator.menu;
import christmas.controller.preprocess.api;

import christmas.validator.RaiseExceptions;

import java.util.List;

public class OrderMenu {
    RaiseExceptions Exceptions = new RaiseExceptions();

    public void validate(String name, List duplicate, List catalog) {
        Exceptions.duplicate(duplicate.contains(name));
        Exceptions.matching(!(catalog.contains(name)));
        duplicate.add(name);
    }
}
