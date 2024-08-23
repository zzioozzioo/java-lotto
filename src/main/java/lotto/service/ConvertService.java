package lotto.service;

import lotto.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// controller가 service 호출하는 것..
public class ConvertService {

    private Validator validator;

    public List<Integer> convertStringToList(String str) {
        String[] strArr = str.split(",");
        for (String s : strArr) {
            validator.isNumeric(s);
        }

        List<Integer> list = IntStream.range(0, strArr.length)
                .mapToObj(i -> Integer.parseInt(strArr[i]))
                .collect(Collectors.toList());

        validator.validateWinningNumber(list);

        return list;
    }

    public int convertInputAmount(String str) {
        validator.isNumeric(str);
        int num = convert(str);

        validator.validateInputAmount(num);
        return num;
    }

    public int convertBonusNumber(String str) {
        validator.isNumeric(str);
        int num = convert(str);

        validator.validateBonusNumber(num);
        return num;
    }
    public int convert(String str) {
        int num = Integer.parseInt(str);
        return num;
    }
}
