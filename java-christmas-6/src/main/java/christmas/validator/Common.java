package christmas.validator;

public class Common {
    private static final String IS_ONLY_NUMBER = "[0-9]+";
    public boolean isInteger(String number) {
        return number.matches(IS_ONLY_NUMBER);
    }
}
