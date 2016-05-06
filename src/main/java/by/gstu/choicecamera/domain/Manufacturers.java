package by.gstu.choicecamera.domain;

public enum Manufacturers {
    NIKON(6, "Nikon"),
    CANON(7, "Canon"),
    PANASONIC(3, "Panasonic"),
    FUJIFILM(2, "Fujifilm"),
    OLYMPUS(1, "Olympus"),
    SONY(5, "Sony"),
    SAMSUNG(4, "SAMSUNG");

    int value;
    String string;

    Manufacturers(int val, String str) {
        value = val;
        string = str;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val)
    {
        value=val;
    }

    public String getString() {
        return string;
    }
}
