package vn.edu.iuh.fit.models;

public enum Status {
    ACTIVE(1),
    DEACTIVE(0),
    DELETED(-1);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
