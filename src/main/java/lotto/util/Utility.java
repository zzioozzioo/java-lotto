package lotto.util;

import lotto.domain.Lotto;
import lotto.exception.HasNotValueException;
import lotto.exception.NotNumericException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    public static int convert(String str) {
        return Integer.parseInt(str);
    }

    public static void hasValue(String s) {
        if (s == null || s.isEmpty()) {
            throw new HasNotValueException();
        }
    }

    public static void isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new NotNumericException();
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
