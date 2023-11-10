package christmas.controller;

import christmas.model.Errors;
public class Validator {
    private static final String IS_ONLY_NUMBER = "[0-9]+";

    public int isDayValid(String day) {
        if (isInteger(day) && isRangeValid(day))
            return Integer.parseInt(day);
        throw new IllegalArgumentException(Errors.DAY.getMessage());
    }
    public boolean isInteger(String number) {
        return number.matches(IS_ONLY_NUMBER);
    }
    public boolean isRangeValid(String number) {
        int parsed = Integer.parseInt(number);
        return 1 <= parsed && parsed <= 31;
    }
}
