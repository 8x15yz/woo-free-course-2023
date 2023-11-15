package christmas.controller.calculate;

import christmas.model.Menus;
import christmas.model.Orders;
import christmas.model.Prices;
import christmas.view.Output;

import java.util.List;

public class Pay {
    Output out = new Output();
    Menus[] menus = Menus.values();
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
}
