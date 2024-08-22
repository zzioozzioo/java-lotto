package lotto.validation;

public class Validator {

    /**
     * 당첨 번호 입력 기능 예외 처리
     */
    // 6개의 당첨 번호에 대한 validation
    public void validateDuplicateWinningNumber() {
        isDigit();
        isInRange();
        isDuplicated();
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
