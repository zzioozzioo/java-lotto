package lotto.exception;

import lotto.constant.ConstNumber;

public class InvalidLengthException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호의 개수는 " + ConstNumber.LOTTO_NUM_LENGTH.getNum() + "개여야 합니다.";

    public InvalidLengthException() {
        super(ERROR_MESSAGE);
    }
}
