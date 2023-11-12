package christmas.model;

public enum Badges {
    SANTA("산타", -20000),
    TREE("트리", -10000),
    STAR("별", -5000),
    NONE("없음", 0);

    private final String name;
    private final int boundary;
    Badges(String name, int boundary) {
        this.name = name;
        this.boundary = boundary;
    }

    public int getBoundary() {
        return this.boundary;
    }

    public String getName() {
        return this.name;
    }

}
