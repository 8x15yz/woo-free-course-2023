package christmas.view;
import java.text.NumberFormat;

public class Output {
    NumberFormat numberFormat = NumberFormat.getInstance();
    private final String HELLO = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String RESULT = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final String LEFT = "<";
    private final String RIGHT = ">";
    private final String RESULT_MENU = "주문 메뉴";
    private final String RESULT_TOTAL = "할인 전 총주문 금액";
    private final String RESULT_GIFT = "증정 메뉴";
    private final String GIFT = "샴페인 1개";
    private final String RESULT_BENEFIT = "혜택 내역";
    private final String RESULT_BENEFIT_TOTAL = "총혜택 금액";
    private final String RESULT_SALE = "할인 후 예상 결제 금액";
    private final String RESULT_BADGE = "12월 이벤트 배지";
    private final String CNT = "개";
    private final String WON = "원";
    private final String VOID = " ";
    private final String COLON = ": ";
    private final String NONE = "없음";

    

    public void jump() {
        System.out.println();
    }
    public void hello() {
        System.out.println(HELLO);
    }
    public void error(String sentence) {
        System.out.println(sentence);
    }
    public void result() {
        System.out.println(RESULT);
    }
    public void menu() {
        jump();
        System.out.println(LEFT+RESULT_MENU+RIGHT);
    }
    public void eachMenu(String menu, int cnt) {
        System.out.println(menu+VOID+cnt+CNT);
    }
    public void total() {
        jump();
        System.out.println(LEFT+RESULT_TOTAL+RIGHT);
    }
    public void won(long price) {
        System.out.println(numberFormat.format(price)+WON);
    }
    public void gift() {
        jump();
        System.out.println(LEFT+RESULT_GIFT+RIGHT);
    }
    public void giftTrue() {
        System.out.println(GIFT);
    }
    public void none() {
        System.out.println(NONE);
    }
    public void benefit() {
        jump();
        System.out.println(LEFT+RESULT_BENEFIT+RIGHT);
    }
    public void benefit(String name) {
        System.out.print(name+COLON);
    }
    public void totalBenefit() {
        jump();
        System.out.println(LEFT+RESULT_BENEFIT_TOTAL+RIGHT);
    }
    public void sale() {
        jump();
        System.out.println(LEFT+RESULT_SALE+RIGHT);
    }
    public void badge() {
        jump();
        System.out.println(LEFT+RESULT_BADGE+RIGHT);
    }
}

