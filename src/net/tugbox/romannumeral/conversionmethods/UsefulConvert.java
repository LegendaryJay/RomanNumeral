package net.tugbox.romannumeral.conversionmethods;

import net.tugbox.romannumeral.RomanNumeral;

import java.util.List;

public class UsefulConvert extends ConversionMethod {
    @Override
    public String getMethodName() {
        return "Useful";
    }

    @Override
    public int toArabic(String inputRomanNumeral) {
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        int result = 0;
        for (RomanNumeral romanNumeral :
                romanNumerals) {
            String symbol = romanNumeral.name();
            while (inputRomanNumeral.startsWith(symbol)) {
                result += romanNumeral.getValue();
                inputRomanNumeral = inputRomanNumeral.substring(symbol.length());
            }
        }
        return result;
    }

    @Override
    public String toRomanNumeral(int arabicNumeral) {
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        StringBuilder stringBuilder = new StringBuilder();
        for (RomanNumeral romanNumeral :
                romanNumerals) {
            while (arabicNumeral > 0 && arabicNumeral >= romanNumeral.getValue()) {
                arabicNumeral -= romanNumeral.getValue();
                stringBuilder.append(romanNumeral.name());
            }
        }
        return stringBuilder.toString();
    }
}
