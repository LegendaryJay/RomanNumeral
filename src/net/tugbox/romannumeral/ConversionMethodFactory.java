package net.tugbox.romannumeral;

import net.tugbox.romannumeral.conversionmethods.BoringConvert;
import net.tugbox.romannumeral.conversionmethods.ConversionMethod;
import net.tugbox.romannumeral.conversionmethods.FunConvert;
import net.tugbox.romannumeral.conversionmethods.UsefulConvert;

public class ConversionMethodFactory {
    public ConversionMethod makeConversionMethod(int x) {
        return switch (x) {
            case 0 -> new BoringConvert();
            case 1 -> new FunConvert();
            case 2 -> new UsefulConvert();
            default -> null;
        };
    }
}
