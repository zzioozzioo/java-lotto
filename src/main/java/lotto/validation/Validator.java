package lotto.validation;

import java.util.List;

import lotto.domain.Winning;

public class Validator {

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
    public void validateWinningNumber(List<Integer> list) {
        isCorrectLength(list);
        isInRange(list);
        isWinningNumberDuplicated(list);
    }

    public void isCorrectLength(List<Integer> list) {
        if (list.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void isInRange(List<Integer> list) {
        if (!list.stream().allMatch(digit -> digit >= 1 && digit <= 45)) {
            throw new IllegalArgumentException();
        }
    }

    public void isWinningNumberDuplicated(List<Integer> list) {
        if (list.stream().distinct().count() != list.size()) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 보너스 숫자 예외 처리
     */
    public void validateBonusNumber(int num, Winning winning) {
        isBonusNumberInRange(num);
        isBonusNumberDuplicate(num, winning);
    }

    private void isBonusNumberInRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void isBonusNumberDuplicate(int num, Winning winning) {
        List<Integer> list = winning.getWinningNumberList();

        if (list.contains(num)) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 로또 구입 금액 입력 기능 예외 처리
     */
    public void validateInputAmount(int amount) {
        isInputAmountInRange(amount);
        hasChange(amount);
    }

    private void isInputAmountInRange(int amount) {
        if (amount < 1000 || amount > 100000) {
            throw new IllegalArgumentException();
        }
    }

    public void hasChange(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }


}
