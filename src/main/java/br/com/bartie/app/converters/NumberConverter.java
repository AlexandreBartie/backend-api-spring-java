package br.com.bartie.app.converters;

public class NumberConverter {

    public static Double toDouble(String strNumber) {
        if (isValid(strNumber)) {
            String number = formatNumber(strNumber);
            if (isValid(number))
                return Double.parseDouble(number);
        }
        return 0D;
    }

    public static boolean isValid(String strNumber) {
        if (strNumber == null)
            return false;
        String number = formatNumber(strNumber);
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private static String formatNumber(String strNumber) {
        return strNumber.replace(',', '.');
    }
    
}
