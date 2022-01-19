package net.tugbox.romannumeral;

import net.tugbox.romannumeral.conversionmethods.ConversionMethod;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        ConversionMethodFactory cmf = new ConversionMethodFactory();

        for (int j = 0; j < 10; j++) {
            int number = rnd.nextInt(3999);
            System.out.println(" starting number: " + number);

            for (int i = 0; i < 3; i++) {
                ConversionMethod converter = cmf.makeConversionMethod(i);
                String roman = converter.toRomanNumeral(number);
                int arabic = converter.toArabic(roman);
                System.out.println(
                        String.join(" \n",
                                converter.getMethodName(),
                                String.valueOf(roman),
                                String.valueOf(arabic),
                                String.valueOf(number == arabic))
                );
                System.out.println();

            }
            System.out.println("-".repeat(20));
        }
    }
}
