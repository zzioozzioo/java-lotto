package lotto.util;

import lotto.constant.ErrorMessage;

public class Utility {

    public static int convert(String str) {
        return Integer.parseInt(str);
    }

    public static void hasValue(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getErrorMessage());
        }
    }

    public static void isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getErrorMessage());
            }
        }
    }

}
