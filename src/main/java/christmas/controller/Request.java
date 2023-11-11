package christmas.controller;
import christmas.model.Benefits;
import christmas.view.Output;
import christmas.view.Input;
import christmas.model.Menus;
import christmas.controller.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Request {
    Output out = new Output();
    Input in = new Input();
    Validator validator = new Validator();
    public void hello() {
        out.hello();
    }
    public int day() {
        try {
            return validator.isDayValid(in.day());
        } catch (Exception e) {
            out.error(e.getMessage());
        }
        return 0;
    }

    public HashMap order(List<String> catalog) {
        HashMap<String, Integer> orders = new HashMap<>();
        try {
            return validator.isMenuValid(in.menu(), catalog);
        } catch (Exception e) {
            out.error(e.getMessage());
        }
        return orders;
    }
}
