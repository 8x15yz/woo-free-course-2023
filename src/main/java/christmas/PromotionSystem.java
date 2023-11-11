package christmas;

import christmas.controller.Request;
import christmas.controller.Reserve;
import christmas.controller.Preprocess;


public class PromotionSystem {
    Request request = new Request();
    Reserve reserve = new Reserve();
    Preprocess pre = new Preprocess();

    public void run() {
        request.hello();
        reserve.set(
                request.day()
        );
        reserve.set(
            pre.individually(
                request.order()
            )
        );
    }
}
