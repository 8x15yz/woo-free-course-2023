package christmas.model;

import java.util.HashMap;

public enum Menus {
    SOUP("양송이수프", 6000,"appetizer"),
    TAPAS("타파스", 5500,"appetizer"),
    SALAD("시저샐러드", 8000,"appetizer"),
    STEAK("티본스테이크", 55000,"main"),
    RIB("바비큐립", 54000,"main"),
    PASTA_SEAFOOD("해산물파스타", 35000,"main"),
    PASTA_CHRISTMAS("크리스마스파스타", 25000,"main"),
    CAKE("초코케이크", 15000,"dessert"),
    ICECREAM("아이스크림", 5000,"dessert"),
    COLA("제로콜라", 3000,"beverage" ),
    WINE("레드와인", 60000,"beverage"),
    CHAMPAGNE("샴페인", 25000,"beverage");

    private final String name;
    private final int price;
    private final String type;

    Menus(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }
    public String[] getNameType() {
        return new String[] {this.name, this.type};
    }
    public int getPrice(String menu) {
        if(menu.equals(this.name))
            return this.price;
        return 0;
    }

}
