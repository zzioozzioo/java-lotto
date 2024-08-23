package lotto.service;

import lotto.domain.Input;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    private Input input;
    private Lotto lotto;
    private User user;

    Validator validator = new Validator();

    // TODO: 메서드명 다시 고민해보기
    //  아니면 validate하는 코드를 메서드로 따로 빼야 하나? 그건 좀 아닌 것 같은디,,
    public void lottoNumberToList() {
        String winningNumber = input.getWinningNumber();
        String[] winningNumberArr = winningNumber.split(",");

        // TODO: winningNumberArr[i] 하나하나에 대해 isNumeric() 검증을 하는 방법
        //  1. 얜 진짜 아닌 것 같음 ㅜㅜ
        //  List<Integer> winningNumberList = IntStream.range(0, winningNumberArr.length)
        //        .mapToObj(i -> {
        //            String number = winningNumberArr[i];
        //            if (isNumeric(number)) {
        //                return Integer.parseInt(number);
        //            } else {
        //                throw new IllegalArgumentException("Invalid number format at index " + i + ": " + number);
        //            }
        //        })
        //        .collect(Collectors.toList());
        //  2. 그냥 for문 돌려서 인덱스 하나하나마다 validator.isNumeric() 호출
        //  -> 얘는 매개변수 하나 생김, validateWinningNumber에서는 제외

        for (String s : winningNumberArr) {
            validator.isNumeric(s);
        }

        List<Integer> winningNumberList = IntStream.range(0, winningNumberArr.length)
                .mapToObj(i -> Integer.parseInt(winningNumberArr[i]))
                .collect(Collectors.toList());

        input.setWinningNumberList(winningNumberList);

        validator.validateWinningNumber();
        lotto.setWinningNumberList(winningNumberList);
    }

    public void bonusNumberToInt() {
        String bonusNumberString = input.getBonusNumberString();
        validator.isNumeric(bonusNumberString);

        int bonusNumber = Integer.parseInt(bonusNumberString);
        input.setBonusNumber(bonusNumber);

        validator.validateBonusNumber();
        lotto.setBonusNumber(bonusNumber);
    }

    public void buyAmountToInt() {
        String buyAmountString = input.getBuyAmountString();
        validator.isNumeric(buyAmountString);

        int buyAmount = Integer.parseInt(buyAmountString);
        input.setBuyAmount(buyAmount);

        validator.validateInputAmount();
        user.setBuyAmount(buyAmount);
    }

}
