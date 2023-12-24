package christmas.validator;

public class RaiseExceptions {
    public void day(Boolean req) {
        if (req) throw new IllegalArgumentException(Errors.DAY.getMessage());
    }
    public void format(Boolean req) {
        if (req) throw new IllegalArgumentException(Errors.MENU.getMessage());
    }
    public void number(Boolean req) {
        if (req) throw new IllegalArgumentException(Errors.MENU.getMessage());
    }
    public void beverage(Boolean req) {
        if (req) throw new IllegalArgumentException(Errors.NOT_ONLY.getMessage());
    }
    public void duplicate(Boolean req) {
        if (req) throw new IllegalArgumentException(Errors.MENU.getMessage());
    }
    public void matching(Boolean req) {
        if (req) throw new IllegalArgumentException(Errors.MENU.getMessage());
    }
    public void overOrder(Boolean req) {
        if (req) throw new IllegalArgumentException(Errors.TWENTY.getMessage());
    }

}
