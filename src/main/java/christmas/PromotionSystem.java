package christmas;

import christmas.controller.Request;
import christmas.controller.Reserve;
import christmas.controller.preprocess.Preprocess;
import christmas.controller.calculate.Calculate;
import christmas.view.Output;

import java.util.List;
public class PromotionSystem {
    Output out = new Output();
    Request request = new Request();
    Reserve reserve = new Reserve();
    Preprocess pre = new Preprocess();
    Calculate calculate = new Calculate();

    public void run() {
        try {
            int day = inputDay();
            List order = inputMenu();
            total(order);
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
        return reserve.set(request.day());
    }
    public List inputMenu() {
        // 기능 2. 주문 입력받아서 주문정보 저장
        return reserve.set(
                pre.part(
                        request.order()
                )
        );
    }
    public void total(List order) {
        // 기능 3-1. 주문 메뉴 출력, 총 주문 금액 계산하여 출력
        out.result();
        out.menu();
        long price = calculate.total(order);
        out.total();
        out.won(price);

        // 기능 3-2. 총 주문금액에 따라 증정여부 판단 후 혜택 출력
        out.gift();
        calculate.gift(price);
    }
    public void benefit (int day, List order) {
        // 기능 4. 사용자가 받을 혜택 금액을 각각 계산
        out.benefit();
        calculate.benefit(day, order);

        // 기능 5. 사용자가 받을 총 혜택 금액을 계산
        out.totalBenefit();
        calculate.totalBenefit();
    }
    public void sale() {
        //기능 6. 혜택 출력, 총 할인가 및 예상 결제금액 출력
        out.sale();
        calculate.sale();
    }
    public void badge() {
        // 기능 7. 뱃지 등급 출력
        out.badge();
        calculate.badge();
    }
}
