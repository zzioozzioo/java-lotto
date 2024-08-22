package lotto.validation;

import lotto.domain.Input;

public class Validator {

    private Input input;

    /**
     * 당첨 번호 입력 기능 예외 처리
     */
    // 6개의 당첨 번호에 대한 validation
    public void validateDuplicateWinningNumber() {
        isDigit();
        isInRange();
        isDuplicated();

        // TODO: 사용자가 입력한 숫자가 6개인지 여부 체크하는 validation method 만들기
    }

    public void isDigit() {
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
        isDigit();
        isInRange();
        hasChange();
    }

    public void hasChange() {
    }


}
