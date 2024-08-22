package lotto.service;

import lotto.domain.Input;
import lotto.domain.Lotto;
import lotto.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// TODO: 당첨 번호 입력값 validate해서 로또 객체에 저장
public class LottoService {

    private Input input;
    private Lotto lotto;

    Validator validator = new Validator();

    // TODO: 메서드명 다시 고민해보기
    //  아니면 validate하는 코드를 메서드로 따로 빼야 하나? 그건 좀 아닌 것 같은디,,
    public void lottoNumberToList() {
        String winningNumber = input.getWinningNumber();
        String[] winningNumberArr = winningNumber.split(",");

        List<Integer> winningNumberList = IntStream.range(0, winningNumberArr.length)
                .mapToObj(i -> Integer.parseInt(winningNumberArr[i]))
                .collect(Collectors.toList());

        input.setWinningNumberList(winningNumberList);

        validator.validateDuplicateWinningNumber();
    }

    public void bonusNumberToInt() {
        String bonusNumberString = input.getBonusNumberString();
        int bonusNumber = Integer.parseInt(bonusNumberString);

        input.setBonusNumber(bonusNumber);

        validator.validateDuplicateBonusNumber();
    }

}
