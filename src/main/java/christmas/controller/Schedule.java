package christmas.controller;

import christmas.model.Benefits;
public class Schedule {
    public static int visit = 0;
    Benefits[] values = Benefits.values();
    public void set(int day) {
        visit = day;
        dday(day);
        weekday(type(day));
        weekend(type(day));
        star(day);

//        for (Benefits value : values) value.Test();
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

}
