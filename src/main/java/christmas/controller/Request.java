package christmas.controller;
import christmas.model.Errors;
import christmas.view.Output;
import christmas.view.Input;
import christmas.controller.Validator;
public class Request {
    Output out = new Output();
    Input in = new Input();
    Validator validator = new Validator();
    public void hello() {
        out.hello();
    }
    public int day() {
        try {
            String day = in.day();
            return validator.isDayValid(day);
        } catch (Exception e) {
            out.error(e.getMessage());
        }
        return 0;
    }
}
