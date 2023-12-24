package christmas.controller.calculate;

import christmas.model.Benefits;
import christmas.model.Prices;
import christmas.model.Badges;
import christmas.view.Output;

public class SalePrice {
    Benefits[] benefits = Benefits.values();
    Badges[] badges = Badges.values();
    Output out = new Output();


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
