package christmas.validator;

public class Day {
    Common common = new Common();
    public int day(String day) {
        if (!(common.isInteger(day) && range(day)))
            throw new IllegalArgumentException(
                    Errors.DAY.getMessage()
            );
        return Integer.parseInt(day);
    }
    public boolean range(String number) {
        int parsed = Integer.parseInt(number);
        return 1 <= parsed && parsed <= 31;
    }
}
