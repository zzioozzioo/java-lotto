package lotto.exception;

public class DuplicatedLottoNumException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 중복이 없어야 합니다.";

    public DuplicatedLottoNumException() {
        super(ERROR_MESSAGE);
    }
}
