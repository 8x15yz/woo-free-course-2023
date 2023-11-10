package christmas.model;

public enum Benefits {
    D_DAY("크리스마스 디데이 할인"),
    DAY("평일 할인"),
    END("주말 할인"),
    STAR("특별 할인"),
    GIFT("증정 이벤트");

    private final String name;
    private int price;
    private Boolean benefit;

    Benefits(String name) {
        this.name = name;
    }
    public void check(Boolean check) {
        this.benefit = check;
    }
    public String getName() {
        return this.name;
    }
    public Boolean getBenefit() {
        return this.benefit;
    }
    public void setBenefit(int price) {
        this.price = price;
    }
    public void Test() {
        System.out.println(this.name+""+this.benefit+"!!!!!!!!");
    }

}
