package lotto.exception;

import lotto.constant.ConstNumber;

public class NotInRangeWinningNumException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 " + ConstNumber.LOTTO_FIRST_NUM.getNum() + "부터 " + ConstNumber.LOTTO_LAST_NUM.getNum() + " 사이의 숫자여야 합니다.";

    public NotInRangeWinningNumException() {
        super(ERROR_MESSAGE);
    }
}
