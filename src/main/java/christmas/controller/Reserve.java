package christmas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import christmas.model.Benefits;
import christmas.model.Menus;

public class Reserve {
    public static int visit = 0;
    Benefits[] benefitValues = Benefits.values();
    Menus[] menuValues = Menus.values();
    public void set(int day) {
        visit = day;
        dday(day);
        weekday(type(day));
        weekend(type(day));
        star(day);

//        for (Benefits value : benefitValues) value.Test();
    }
    public int type(int day) {
        return (day-1)%7;
    }
    public void dday(int day) {
        Benefits.D_DAY.check(1 <= day && day <= 25);
    }
    public void weekday(int day) {
        Benefits.DAY.check(2 <= day);
    }
    public void weekend(int day) {
        Benefits.END.check(day < 2);
    }
    public void star(int day) {
        Benefits.STAR.check(type(day) == 2 || day == 25);
    }

    public void set(HashMap menu) {

    }

    public List catalog() {
        List<String> catalog = new ArrayList<>();
        for (Menus value : menuValues)
            catalog.add(value.getName());
        return catalog;
    }
}
