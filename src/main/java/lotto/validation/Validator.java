package lotto.validation;

import lotto.domain.Input;

import java.util.List;

public class Validator {

    private Input input;

    /**
     * 당첨 번호 입력 기능 예외 처리
     */
    // 6개의 당첨 번호에 대한 validation
    public void validateWinningNumber() {
        isNumeric();
        isCorrectLength();
        isInRange();
        isWinningNumberDuplicated();
    }

    public void isNumeric() {


    }

    public void isCorrectLength() {
    }

    public void isInRange() {
    }

    public void isWinningNumberDuplicated() {
    }

    // 보너스 숫자에 대한 validation
    public void validateBonusNumber() {
        isNumeric();
        isInRange();
        isBonusNumberDuplicate();
    }
    public void isBonusNumberDuplicate() {
        // getWinningNumberList해서 해당 숫자가 있는지!! contains 쓰면 될 듯
        List<Integer> list = input.getWinningNumberList();

        if (list.contains(input.getBonusNumber())) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 로또 구입 금액 입력 기능 예외 처리
     */
    public void validateInputAmount() {
        isNumeric();
        isInRange();
        hasChange();
    }

    public void hasChange() {
    }


}
