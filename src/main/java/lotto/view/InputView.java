package lotto.view;

import lotto.exception.HasNotValueException;
import lotto.exception.NotNumericException;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Utility.*;

public class InputView {

    /**
     * 구입 금액 입력
     */
    public int readUserBuyAmount() {
        while (true) {
            try {
                String input = getUserBuyAmount();
                validateUserBuyAmount(input);
                return convert(input);
            } catch (HasNotValueException | NotNumericException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getUserBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine().trim();
    }

    public void validateUserBuyAmount(String input) {
        hasValue(input);
        isNumeric(input);
    }

    /**
     * 당첨 번호 입력
     */
    public List<Integer> readLottoWinningNumber() {
        while (true) {
            try {
                String input = getLottoWinningNumber();
                return validateWinningNumber(input);
            } catch (HasNotValueException | NotNumericException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getLottoWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        return readLine().trim();
    }

    public List<Integer> validateWinningNumber(String input) {
        hasValue(input);
        String[] strArr = splitString(input);
        validateIsWinningNumberNumeric(strArr);
        return convertStrArrToList(strArr);
    }

    public void validateIsWinningNumberNumeric(String[] strArr) {
        for (String s : strArr) {
            isNumeric(s);
        }
    }

    /**
     * 보너스 번호 입력
     */
    public int readLottoBonusNumber() {
        while (true) {
            try {
                String input = getLottoBonusNumber();
                validateBonusNumber(input);
                return convert(input);
            } catch (HasNotValueException | NotNumericException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getLottoBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        return readLine().trim();
    }

    public void validateBonusNumber(String input) {
        hasValue(input);
        isNumeric(input);
    }
}
