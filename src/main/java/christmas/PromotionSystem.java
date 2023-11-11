package christmas;
import java.util.List;

import christmas.controller.Request;
import christmas.controller.Reserve;

public class PromotionSystem {
    Request request = new Request();
    Reserve reserve = new Reserve();

    public void run() {
        request.hello();
        reserve.set(
                request.day()
        );
        reserve.set(
                request.order(reserve.catalog())
        );
    }
}
