package christmas;

import christmas.controller.Request;
import christmas.controller.Schedule;

public class PromotionSystem {
    public void run() {
        Request request = new Request();
        Schedule schedule = new Schedule();

        request.hello();
        schedule.set(request.day());

    }
}
