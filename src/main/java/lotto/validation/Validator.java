package lotto.validation;

import lotto.domain.Input;

public class Validator {

    private Input input;

    /**
     * 당첨 번호 입력 기능 예외 처리
     */
    // 6개의 당첨 번호에 대한 validation
    public void validateDuplicateWinningNumber() {
        isDigit(input.getBuyAmount());
        isInRange();
        isDuplicated();
    }

    public void isDigit(String buyAmount) {
    }

    public void isInRange() {
    }

    public void isDuplicated() {
    }

    // 보너스 숫자에 대한 validation
    public void validateDuplicateBonusNumber() {
    }

    /**
     * 로또 구입 금액 입력 기능 예외 처리
     */
    public void validateInputAmount() {
        isDigit(input.getBuyAmount());
        isInRange();
        hasChange();
    }

    public void hasChange() {
    }


}
