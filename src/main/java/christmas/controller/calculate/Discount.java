package christmas.controller.calculate;

import christmas.model.Benefits;
import christmas.model.Menus;
import christmas.model.Orders;
import christmas.view.Output;
import java.util.List;

public class Discount {

    Menus[] menus = Menus.values();
    Benefits[] benefits = Benefits.values();
    Output out = new Output();

    public void viewGift() {
        if (Benefits.GIFT.isTrue()) out.giftTrue();
        if (!Benefits.GIFT.isTrue()) out.none();
    }
    public void benefit(int day, List<Orders> orders) {
        for (Benefits benefit: benefits) {
            if (benefit.isTrue()) {
                long sale = distribute(benefit.name(), orders, day);
                if (sale >= 0) benefit.check(false);
                benefit.setBenefit(sale);
            }
        }
        printBenefit();
    }
    public void printBenefit () {
        Boolean all = true;
        for (Benefits benefit: benefits) {
            if (benefit.isTrue()) {
                out.benefit(benefit.getName());
                out.won(benefit.getPrice());
                all = false;
            }
        }
        if (all) out.none();
    }
    public long distribute(String name, List<Orders> orders, int day) {
        if (name.equals("D_DAY")) return dday(day);
        if (name.equals("DAY")) return week(orders, "dessert");
        if (name.equals("END")) return week(orders, "main");
        if (name.equals("STAR")) return star();
        if (name.equals("GIFT")) return gift();
        return 0;
    }
    public long week(List<Orders> orders, String type) {
        long sale = 0;
        for (Menus value: menus) {
            String[] catalog = value.getCatalog();
            for(Orders order: orders) {
                sale -= week(order, catalog, type);
            }
        }
        return sale;
    }
    public long week(Orders order, String[] catalog, String type) {
        if (order.getName().equals(catalog[0]) && catalog[1].equals(type))
            return order.getCnt() * 2023;
        return 0;
    }
    public long star() {
        return -1000;
    }
    public long dday(int day) {
        return -1*(1000+(day-1)*100);
    }
    public long gift() {
        return -25000;
    }
}
