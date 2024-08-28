package lotto.service;

import lotto.domain.Winning;
import lotto.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertService {

    private Validator validator = new Validator();

    public List<Integer> convertStringToList(String str) {
        String[] strArr = str.split(",");
        validateNumericArray(strArr);

        List<Integer> list = convertArrayToList(strArr);
        return list;
    }

    public void validateNumericArray(String[] strArr) {
        for (String s : strArr) {
            validator.isNumeric(s);
        }
    }

    public List<Integer> convertArrayToList(String[] strArr) {
        return IntStream.range(0, strArr.length)
                .mapToObj(i -> Integer.parseInt(strArr[i]))
                .collect(Collectors.toList());
    }

    public int convertInputAmount(String str) {
        validator.isNumeric(str);
        return convert(str);
    }

    public int convertBonusNumber(String str) {
        validator.isNumeric(str);
        return convert(str);
    }

    public int convert(String str) {
        return Integer.parseInt(str);
    }
}
