package christmas.validator;

public enum Errors {
    COMMON("[ERROR] "),
    DAY("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    TWENTY("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    NOT_ONLY ("음료만 주문 시, 주문할 수 없습니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }
    public String getMessage() {
        return COMMON.message + this.message;
    }
}