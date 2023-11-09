package christmas.view;

public class Output {
    private final String HELLO = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String INPUT_WHEN = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final String INPUT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final String RESULT = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final String LEFT = "<";
    private final String RIGHT = ">";
    private final String RESULT_MENU = "주문 메뉴";
    private final String RESULT_TOTAL = "할인 전 총주문 금액";
    private final String RESULT_GIFT = "증정 메뉴";
    private final String RESULT_BENEFIT = "혜택 내역";
    private final String RESULT_BENEFIT_TOTAL = "총혜택 금액";
    private final String RESULT_SALE = "할인 후 예상 결제 금액";
    private final String RESULT_BADGE = "12월 이벤트 배지";

    public void hello() {
        System.out.println(HELLO);
    }
    public void when() {

        System.out.println(INPUT_WHEN);
    }

    public void menu() {
        System.out.println(INPUT_MENU);
    }


}

