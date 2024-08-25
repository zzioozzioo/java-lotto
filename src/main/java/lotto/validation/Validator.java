package lotto.validation;

import java.util.List;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;
import lotto.domain.Winning;

public class Validator {

    // TODO: isNumeric()에서 문자열->문자 변환 다른 방법?

    ErrorMessage errorMessage;
    ConstNumber constNumber;

    /**
     * 공통 예외 처리
     */
    public void isNumeric(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException(errorMessage.NOT_NUMERIC.getErrorMessage());
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
        if (list.size() != constNumber.LOTTO_NUM_LENGTH.getNum()) {
            throw new IllegalArgumentException(errorMessage.NOT_CORRECT_LENGTH.getErrorMessage());
        }
    }

    public void isWinningNumberInRange(List<Integer> list) {
        if (!list.stream().allMatch(digit -> digit >= constNumber.LOTTO_FIRST_NUM.getNum() && digit <= constNumber.LOTTO_LAST_NUM.getNum())) {
            throw new IllegalArgumentException(errorMessage.NOT_IN_RANGE_WINNING_NUM.getErrorMessage());
        }
    }

    public void isWinningNumberDuplicated(List<Integer> list) {
        if (list.stream().distinct().count() != list.size()) {
            throw new IllegalArgumentException(errorMessage.DUPLICATED_WINNING_NUM.getErrorMessage());
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
        if (num < constNumber.LOTTO_FIRST_NUM.getNum() || num > constNumber.LOTTO_LAST_NUM.getNum()) {
            throw new IllegalArgumentException(errorMessage.NOT_IN_RANGE_WINNING_NUM.getErrorMessage());
        }
    }

    public void isBonusNumberDuplicate(int num, Winning winning) {
        List<Integer> list = winning.getWinningNumberList();

        if (list.contains(num)) {
            throw new IllegalArgumentException(errorMessage.DUPLICATED_WINNING_NUM.getErrorMessage());
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
        if (amount < constNumber.INPUT_AMOUNT_MIN.getNum() || amount > constNumber.INPUT_AMOUNT_MAX.getNum()) {
            throw new IllegalArgumentException(errorMessage.NOT_IN_RANGE_INPUT_AMOUNT.getErrorMessage());
        }
    }

    public void hasChange(int amount) {
        if (amount % constNumber.LOTTO_PRICE.getNum() != 0) {
            throw new IllegalArgumentException(errorMessage.HAS_CHANGE.getErrorMessage());
        }
    }


}
