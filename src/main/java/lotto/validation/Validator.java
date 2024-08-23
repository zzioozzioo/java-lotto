package lotto.validation;

import lotto.domain.Input;

import java.util.List;

public class Validator {

    private Input input;

    // TODO: input.getWinningNumberList이 중복되는데 클래스 전역 변수로 사용해도 되나..? 그건 좀 그렇겠지
    // TODO: isNumeric()에서 문자열->문자 변환 다른 방법?

    /**
     * 공통 예외 처리
     */
    public void isNumeric(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 당첨 번호 입력 기능 예외 처리
     */
    public void validateWinningNumber() {
        isCorrectLength();
        isInRange();
        isWinningNumberDuplicated();
    }

    public void isCorrectLength() {
        if (input.getWinningNumberList().size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void isInRange() {
        if (!input.getWinningNumberList().stream().allMatch(digit -> digit >= 1 && digit <= 45)) {
            throw new IllegalArgumentException();
        }
    }

    public void isWinningNumberDuplicated() {
        if (input.getWinningNumberList().stream().distinct().count() != input.getWinningNumberList().size()) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 보너스 숫자 예외 처리
     */
    public void validateBonusNumber() {
        isBonusNumberInRange();
        isBonusNumberDuplicate();
    }

    private void isBonusNumberInRange() {
        if (input.getBonusNumber() < 1 || input.getBonusNumber() > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void isBonusNumberDuplicate() {
        List<Integer> list = input.getWinningNumberList();

        if (list.contains(input.getBonusNumber())) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 로또 구입 금액 입력 기능 예외 처리
     */
    public void validateInputAmount() {
        isInputAmountInRange();
        hasChange();
    }

    private void isInputAmountInRange() {
        if (input.getBonusNumber() < 1000 || input.getBonusNumber() > 100000) {
            throw new IllegalArgumentException();
        }
    }

    public void hasChange() {
        if (input.getBuyAmount() % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }


}
