package net.tugbox.romannumeral.conversionmethods;

import java.util.ArrayList;
import java.util.Collections;


public class BoringConvert extends ConversionMethod {
    private static final String[] key = new String[]{"I", "V", "X", "L", "C", "D", "M"};

    private static String solveDigit(int digitPlace, int digitValue) {
        if (digitValue == 0) {
            return "";
        }
        int keyPlace = digitPlace * 2;
        String one = key[keyPlace];

        return switch (digitValue) {
            case 9 -> (one + key[keyPlace + 2]);
            case 4 -> (one + key[keyPlace + 1]);
            default -> {
                String fiveValue = "";
                if (digitValue >= 5) {
                    digitValue -= 5;
                    fiveValue = key[keyPlace + 1];
                }
                yield (fiveValue + one.repeat(digitValue));
            }
        };
    }

    @Override
    public String getMethodName() {
        return "Boring";
    }

    @Override
    public int toArabic(String inputRomanNumeral) {
        //i know this is stupid. I dont wanna talk about it.
        ArrayList<String> newKey = new ArrayList<>();
        ArrayList<Integer> newValues = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int x = i * 2;
            int power = (int) Math.pow(10, i);
            newKey.add(key[x]); //1
            newValues.add(power);

            newKey.add(key[x] + key[x + 1]);//4
            newValues.add(power * 4);

            newKey.add(key[x + 1]);//5
            newValues.add(power * 5);

            newKey.add(key[x] + key[x + 2]);//9
            newValues.add(power * 9);
        }
        newKey.add(key[key.length - 1]);
        newValues.add(1000);
        Collections.reverse(newKey);
        Collections.reverse(newValues);

        int result = 0;
        for (int i = 0; i < newKey.size(); i++) {
            String symbol = newKey.get(i);
            int value = newValues.get(i);
            while (inputRomanNumeral.length() >= symbol.length() && inputRomanNumeral.startsWith(symbol)) {
                result += value;
                inputRomanNumeral = inputRomanNumeral.substring(symbol.length());
            }
        }

        return result;

    }

    @Override
    public String toRomanNumeral(int arabicNumeral) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] digits = getDigitArray(arabicNumeral);

        for (int i = 0; i < digits.length; i++) {
            stringBuilder.append(
                    solveDigit(digits.length - 1 - i, digits[i])
            );
        }

        return stringBuilder.toString();
    }

}
