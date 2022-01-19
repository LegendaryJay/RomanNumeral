package net.tugbox.romannumeral.conversionmethods;

public abstract class ConversionMethod {
    public abstract String getMethodName();

    public abstract int toArabic(String romanNumeral);

    public abstract String toRomanNumeral(int arabicNumeral);


    protected int[] getDigitArray(int x) {
        return Integer.toString(x).chars().map(a -> a - '0').toArray();
    }
}
