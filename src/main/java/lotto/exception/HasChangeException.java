package lotto.exception;

import lotto.constant.ConstNumber;

public class HasChangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] " + ConstNumber.LOTTO_PRICE.getNum() +"원 단위로 입력하셔야 합니다.";

    public HasChangeException() {
        super(ERROR_MESSAGE);
    }
}
