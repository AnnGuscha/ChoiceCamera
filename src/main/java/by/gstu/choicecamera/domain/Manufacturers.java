package by.gstu.choicecamera.domain;

public enum Manufacturers {
    CANON(1, "Canon"),
    NIKON(2, "Nikon"),
    SONY(3, "Sony"),
    PANASONIC(4, "Panasonic"),
    SAMSUNG(5, "SAMSUNG"),
    FUJIFILM(6, "Fujifilm"),
    OLYMPUS(7, "Olympus");

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
