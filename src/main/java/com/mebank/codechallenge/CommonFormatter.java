package com.mebank.codechallenge;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;

public class CommonFormatter {

    public static LocalDateTime getLocalDateTimeFromString(String input) {
        return LocalDateTime.parse(input, GlobalConstants.formatter);
    }

    public static long convertCurrencyToCents(String inputNumber){
        double interimVal = Double.parseDouble(inputNumber);
        interimVal *= 100;
        return (long) interimVal;
    }

    public static String convertCentToDollarDisplay(long centValue){
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        return nf.format(centValue / 100.0);
    }

}
