package christmas;

import christmas.controller.Request;
import christmas.controller.Reserve;
import christmas.controller.preprocess.Preprocess;
import christmas.controller.calculate.Pay;
import christmas.controller.calculate.Discount;
import christmas.controller.calculate.SalePrice;
import christmas.view.Output;

import java.util.List;
public class PromotionSystem {
    Output out = new Output();
    Request request = new Request();
    Reserve reserve = new Reserve();
    Preprocess pre = new Preprocess();
    Pay pay = new Pay();
    Discount discount = new Discount();
    SalePrice sale = new SalePrice();

    public void run() {
        try {
            int day = inputDay();
            List order = inputMenu();
            total(day, order);
            benefit(day, order);
            sale();
            badge();
        } catch (Exception e) {
            out.error(e.getMessage());
        }
    }
    public int inputDay() {
        out.hello();
        // 기능 1. 날짜 입력받아 혜택 구분하기
        return request.day();
    }
    public List inputMenu() {
        // 기능 2. 주문 입력받아서 주문정보 저장
        return reserve.set(
                pre.part(
                        request.order()
                )
        );
    }
    public void total(int day, List order) {
        // 기능 3-1. 주문 메뉴 출력, 총 주문 금액 계산하여 출력
        out.result(day);
        out.menu();
        long price = pay.total(order);
        out.total();
        out.won(price);

        //  기능 3-2. 총 지불금액이 10000원 넘는지 확인 후 주문정보 저장
        reserve.set(day, price);
        // 기능 4. 사용자가 받을 혜택 금액을 각각 계산
        out.benefit();
        discount.benefit(day, order);

        // 기능 3-3. 총 주문금액에 따라 증정여부 판단 후 혜택 출력
        out.gift();
        discount.viewGift();
    }
    public void benefit (int day, List order) {

        // 기능 5. 사용자가 받을 총 혜택 금액을 계산
        out.totalBenefit();
        sale.totalBenefit();
    }
    public void sale() {
        //기능 6. 혜택 출력, 총 할인가 및 예상 결제금액 출력
        out.sale();
        sale.sale();
    }
    public void badge() {
        // 기능 7. 뱃지 등급 출력
        out.badge();
        sale.badge();
    }
}
