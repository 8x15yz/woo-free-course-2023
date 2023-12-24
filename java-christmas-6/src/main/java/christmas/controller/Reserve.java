package christmas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import christmas.model.Benefits;
import christmas.model.Menus;
import christmas.model.Orders;

public class Reserve {
    private List<Orders> reserve = new ArrayList<>();

    public int set(int day, long price) {
            dday(day, isTarget(price));
            weekday(type(day), isTarget(price));
            weekend(type(day), isTarget(price));
            star(day, isTarget(price));
            gift(price);
        return day;
    }
    public Boolean isTarget(long price) {
        return price >= 10000;
    }
    public int type(int day) {
        return (day-1)%7;
    }
    public void dday(int day, Boolean target) {
        Benefits.D_DAY.check((1 <= day && day <= 25)&& target);
    }
    public void weekday(int day, Boolean target) {
        Benefits.DAY.check((2 <= day) && target);
    }
    public void weekend(int day, Boolean target) {
        Benefits.END.check((day < 2) && target);
    }
    public void star(int day, Boolean target) {
        Benefits.STAR.check((type(day) == 2 || day == 25) && target);
    }
    public void gift(long price) {
        Benefits.GIFT.check(price >= 120000);
    }
    public List set(HashMap orders) {
        orders.forEach((name, price) -> {
            reserve.add(new Orders(String.valueOf(name), Integer.parseInt(String.valueOf(price))));
        });
        return reserve;
    }
}
