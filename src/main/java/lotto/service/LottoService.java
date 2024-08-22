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

    public void lottoNumberToList() {
        String winningNumber = input.getWinningNumber();
        String[] winningNumberArr = winningNumber.split(",");

        List<Integer> winningNumberList = IntStream.range(0, winningNumberArr.length)
                .mapToObj(i -> Integer.parseInt(winningNumberArr[i]))
                .collect(Collectors.toList());

        input.setWinningNumberList(winningNumberList);

        validator.validateDuplicateWinningNumber();
    }

}
