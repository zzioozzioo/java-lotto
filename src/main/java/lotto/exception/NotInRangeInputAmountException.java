package lotto.exception;

import lotto.constant.ConstNumber;

public class NotInRangeInputAmountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액은 " + ConstNumber.INPUT_AMOUNT_MIN.getNum() + "와 " + ConstNumber.INPUT_AMOUNT_MAX.getNum() + "사이여야 합니다.";

    public NotInRangeInputAmountException() {
        super(ERROR_MESSAGE);
    }
}
