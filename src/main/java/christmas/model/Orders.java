package christmas.model;

public class Orders {
    private static final int INIT = 0;
    private final String name;
    private int cnt;

//    public Orders(String name) {
//        this(name, INIT);
//    }
    public Orders(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }
    public String getName() {
        return name;
    }
    public int getCnt() {
        return cnt;
    }

}
