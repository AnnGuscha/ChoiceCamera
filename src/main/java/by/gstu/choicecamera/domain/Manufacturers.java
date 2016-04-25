package by.gstu.choicecamera.domain;

public enum Manufacturers {
    NIKON(1, "Nikon"),
    CANON(2, "Canon"),
    PANASONIC(3, "Panasonic"),
    FUJIFILM(4, "Fujifilm"),
    OLYMPUS(5, "Olympus"),
    SONY(6, "Sony");

    int value;
    String string;

    Manufacturers(int val, String str) {
        value = val;
        string = str;
    }

    public int getValue() {
        return value;
    }

    public String getString() {
        return string;
    }
}
