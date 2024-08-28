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

}
