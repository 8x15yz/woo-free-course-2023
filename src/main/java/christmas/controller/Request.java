package christmas.controller;
import christmas.view.Input;
import christmas.validator.Day;

public class Request {
    Input in = new Input();

    public int day() {
        Day validator = new Day();
        try {
            return validator.day(
                    in.day()
            );
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String order() {
        try {
            return in.menu();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
