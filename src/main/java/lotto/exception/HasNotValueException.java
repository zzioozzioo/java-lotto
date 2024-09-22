package lotto.exception;

public class HasNotValueException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 값을 입력해야 합니다.";

    public HasNotValueException() {
        super(ERROR_MESSAGE);
    }
}
