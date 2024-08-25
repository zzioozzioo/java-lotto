package lotto.validation;

import java.util.List;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;
import lotto.domain.Winning;

public class Validator {

    // TODO: isNumeric()에서 문자열->문자 변환 다른 방법?

    /**
     * 공통 예외 처리
     */
    public void isNumeric(String s) {

        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getErrorMessage());
        }

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getErrorMessage());
            }
        }
    }

    /**
     * 당첨 번호 입력 기능 예외 처리
     */
    public void validateWinningNumber(List<Integer> list) {
        isCorrectLength(list);
        isWinningNumberInRange(list);
        isWinningNumberDuplicated(list);
    }

    public void isCorrectLength(List<Integer> list) {
        if (list.size() != ConstNumber.LOTTO_NUM_LENGTH.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_LENGTH.getErrorMessage());
        }
    }

    public void isWinningNumberInRange(List<Integer> list) {
        if (!list.stream().allMatch(digit -> digit >= ConstNumber.LOTTO_FIRST_NUM.getNum() && digit <= ConstNumber.LOTTO_LAST_NUM.getNum())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_WINNING_NUM.getErrorMessage());
        }
    }

    public void isWinningNumberDuplicated(List<Integer> list) {
        if (list.stream().distinct().count() != list.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUM.getErrorMessage());
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
        if (num < ConstNumber.LOTTO_FIRST_NUM.getNum() || num > ConstNumber.LOTTO_LAST_NUM.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_WINNING_NUM.getErrorMessage());
        }
    }

    public void isBonusNumberDuplicate(int num, Winning winning) {
        List<Integer> list = winning.getWinningNumberList();

        if (list.contains(num)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUM.getErrorMessage());
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
        if (amount < ConstNumber.INPUT_AMOUNT_MIN.getNum() || amount > ConstNumber.INPUT_AMOUNT_MAX.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_INPUT_AMOUNT.getErrorMessage());
        }
    }

    public void hasChange(int amount) {
        if (amount % ConstNumber.LOTTO_PRICE.getNum() != 0) {
            throw new IllegalArgumentException(ErrorMessage.HAS_CHANGE.getErrorMessage());
        }
    }


}
