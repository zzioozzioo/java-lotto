package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static String[] splitString(String input) {
        return input.split(",");
    }

    public static List<Integer> convertStrArrToList(String[] strArr) {
        return Arrays.stream(strArr).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Lotto sortLotto(Lotto lotto) {
        return new Lotto(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
    }
}
