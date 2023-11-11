package christmas.controller;
import christmas.view.Output;
import christmas.view.Input;
import christmas.controller.Preprocess;

import java.util.HashMap;
import java.util.List;

public class Request {
    Output out = new Output();
    Input in = new Input();
    Validator validator = new Validator();
    Preprocess pre = new Preprocess();

    public int day() {
        try {
            return validator.isDayValid(in.day());
        } catch (Exception e) {
            out.error(e.getMessage());
        }
        return 0;
    }

    public String order() {
        try {
            return in.menu();
        } catch (Exception e) {
            out.error(e.getMessage());
        }
        return "0";
    }
}
