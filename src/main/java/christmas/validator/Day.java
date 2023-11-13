package christmas.validator;

public class Day {
    RaiseExceptions Exceptions = new RaiseExceptions();
    Common common = new Common();
    public int day(String day) {
        Exceptions.day(!(common.isInteger(day) && range(day)));
        return Integer.parseInt(day);
    }
    public boolean range(String number) {
        int parsed = Integer.parseInt(number);
        return 1 <= parsed && parsed <= 31;
    }
}
