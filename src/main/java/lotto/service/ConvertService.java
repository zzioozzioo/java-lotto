package lotto.service;

import lotto.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertService {

    public void isNumeric(String s) {

        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getErrorMessage());
        }

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getErrorMessage());
            }
        }
    }

    public List<Integer> convertStringToList(String str) {
        String[] strArr = str.split(",");
        validateNumericArray(strArr);

        List<Integer> list = convertArrayToList(strArr);
        return list;
    }

    public void validateNumericArray(String[] strArr) {
        for (String s : strArr) {
            isNumeric(s);
        }
    }

    public List<Integer> convertArrayToList(String[] strArr) {
        return IntStream.range(0, strArr.length)
                .mapToObj(i -> Integer.parseInt(strArr[i]))
                .collect(Collectors.toList());
    }

    public int convertInputAmount(String str) {
        isNumeric(str);
        return convert(str);
    }

    public int convertBonusNumber(String str) {
        isNumeric(str);
        return convert(str);
    }

    public int convert(String str) {
        return Integer.parseInt(str);
    }
}
