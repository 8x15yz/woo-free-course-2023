package christmas;

import christmas.controller.Request;
import christmas.controller.Reserve;
import christmas.controller.Preprocess;
import christmas.controller.Calculate;
import christmas.view.Output;
import christmas.model.Orders;

import java.util.List;
public class PromotionSystem {
    Output out = new Output();
    Request request = new Request();
    Reserve reserve = new Reserve();
    Preprocess pre = new Preprocess();
    Calculate calculate = new Calculate();

    public void run() {
        try {
            // 인삿말
            out.hello();
            // 기능 1. 날짜 입력받아 혜택 구분하기
            int day = reserve.set(
                    request.day()
            );
            // 기능 2. 주문 입력받아서 주문정보 저장
            List<Orders> order = reserve.set(
                    pre.individually(
                            request.order()
                    )
            );
            // 기능 3-1. 주문 메뉴 출력, 총 주문 금액 계산하여 출력
            out.result();
            out.menu();
            long price = calculate.total(order);
            out.total();
            out.won(price);
            // 기능 3-2. 총 주문금액에 따라 증정여부 판단 후 혜택 출력
            out.gift();
            calculate.gift(price);
            // 기능 4. 사용자가 받을 혜택 금액을 각각 계산
            out.benefit();
            calculate.benefit(day, order);
            // 기능 5.
            out.totalBenefit();
            calculate.totalBenefit();
            //기능 6.
        } catch (Exception e) {

        }

    }
}
