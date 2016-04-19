package by.gstu.choicecamera.domain;

public enum Manufacturers {
    NIKON(1),
    CANON(2),
    PANASONIC(3),
    FUJIFILM(4),
    OLYMPUS(5);
    int value;

    Manufacturers(int val) {
        value = val;
    }

    public int getValue() {
        return value;
    }
}
