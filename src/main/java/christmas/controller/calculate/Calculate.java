package christmas.controller.calculate;

import christmas.model.Orders;
import christmas.model.Menus;
import christmas.model.Benefits;
import christmas.model.Prices;
import christmas.model.Badges;
import christmas.view.Output;
import java.util.List;


public class Calculate {

    private final int start = 10000;

    Menus[] menus = Menus.values();
    Benefits[] benefits = Benefits.values();
    Badges[] badges = Badges.values();
    Output out = new Output();
    public long total(List<Orders> reserve) {
        long total = 0;
        for(Orders res: reserve) {
            out.eachMenu(res.getName(), res.getCnt());
            total = sumTotal(total, res);
        }
        Prices.TOTAL.setPrice(total);
        return Prices.TOTAL.getPrice();
    }
    public long sumTotal (long total, Orders res) {
        for (Menus value: menus) {
            total += value.getPrice(res.getName())*res.getCnt();
        }
        return total;
    }
    public void gift(long price) {
        Benefits.GIFT.setBenefit();
        Benefits.GIFT.check(price >= start);
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
        if (name.equals("DAY")) return week(orders, "main");
        if (name.equals("END")) return week(orders, "dessert");
        if (name.equals("STAR")) return star();
        if (name.equals("GIFT")) return gift();
        return 0;
    }
    public long week(List<Orders> orders, String type) {
        long sale = 0;
        for (Menus value: menus) {
            String[] catalog = value.getCatalog();
            for(Orders order: orders) {
                if (order.getName().equals(catalog[0]) && catalog[1].equals(type)) {
                    sale -= order.getCnt()*2023;
                }
            }
        }
        return sale;
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
    public void totalBenefit() {
        long totalBenefit = 0;
        for (Benefits benefit: benefits) {
            if(benefit.isTrue() && !benefit.name().equals("GIFT")) {
                totalBenefit += benefit.getPrice();
            }
        }
        out.won(Prices.BENEFIT.getPrice());
        Prices.BENEFIT.setPrice(totalBenefit);
    }
    public void sale() {
        Prices.SALE.setPrice(
                Prices.BENEFIT.getPrice()+Prices.TOTAL.getPrice()
        );
        out.won(Prices.SALE.getPrice());
    }
    public void badge() {
        for (Badges badge : badges) {
            if (Prices.BENEFIT.getPrice() <= badge.getBoundary()) {
                out.badge(badge.getName());
                break;
            }
        }
    }

}
