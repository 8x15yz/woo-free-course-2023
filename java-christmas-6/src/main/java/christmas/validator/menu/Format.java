package christmas.validator.menu;

import christmas.validator.RaiseExceptions;

public class Format {
    RaiseExceptions Exceptions = new RaiseExceptions();
    public String[] validate(String[] format) {
        Exceptions.format(format.length != 2);
        return format;
    }
}
