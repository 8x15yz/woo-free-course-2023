package christmas.model;

public enum Prices {
    TOTAL("할인 전 총주문 금액"),
    BENEFIT("총혜택 금액"),
    SALE("할인 후 예상 결제 금액");
    private final String name;
    private long price;

    Prices(String name) {
        this.name = name;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public long getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }
}
