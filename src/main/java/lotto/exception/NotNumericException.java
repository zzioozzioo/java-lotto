package lotto.exception;

import lotto.constant.ConstNumber;

public class NotNumericException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다.";

    public NotNumericException() {
        super(ERROR_MESSAGE);
    }
}
