package christmas.validator.menu;

import christmas.validator.RaiseExceptions;

import java.util.List;

public class MenuValidator {
    RaiseExceptions Exceptions = new RaiseExceptions();

    public void validate(String name, List duplicate, List catalog) {
        Exceptions.duplicate(duplicate.contains(name));
        Exceptions.matching(!(catalog.contains(name)));
        duplicate.add(name);
    }
}
