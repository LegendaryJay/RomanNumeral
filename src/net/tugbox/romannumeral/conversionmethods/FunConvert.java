package net.tugbox.romannumeral.conversionmethods;

public class FunConvert extends ConversionMethod {
    @Override
    public String getMethodName() {
        return "Fun";
    }

    @Override
    public int toArabic(String inputRomanNumeral) {
        return inputRomanNumeral
                .replace("IV", "I".repeat(4))
                .replace("V", "I".repeat(5))
                .replace("IX", "I".repeat(9))

                .replace("XL", "X".repeat(4))
                .replace("L", "X".repeat(5))
                .replace("XC", "X".repeat(9))

                .replace("CD", "C".repeat(4))
                .replace("D", "C".repeat(5))
                .replace("CM", "C".repeat(9))
                .replace("M", "C".repeat(10))
                .replace("C", "X".repeat(10))
                .replace("X", "I".repeat(10)).length();

    }

    @Override
    public String toRomanNumeral(int arabicNumeral) {
        return "I".repeat(arabicNumeral)
                .replace("I".repeat(10), "X")
                .replace("X".repeat(10), "C")
                .replace("C".repeat(10), "M")

                .replace("C".repeat(9), "CM")
                .replace("C".repeat(5), "D")
                .replace("C".repeat(4), "CD")

                .replace("X".repeat(9), "XC")
                .replace("X".repeat(5), "L")
                .replace("X".repeat(4), "XL")

                .replace("I".repeat(9), "IX")
                .replace("I".repeat(5), "V")
                .replace("I".repeat(4), "IV");
    }
}
