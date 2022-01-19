package net.tugbox.romannumeral;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum RomanNumeral {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral x) -> x.value).reversed())
                .toList();
    }

    public int getValue() {
        return value;
    }
}
