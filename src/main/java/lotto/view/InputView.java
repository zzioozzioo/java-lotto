package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Utility.*;

public class InputView {

    /**
     * 구입 금액 입력
     */
    public int readUserBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = readLine().trim();
        validateUserBuyAmount(input);
        return convert(input);
    }

    public void validateUserBuyAmount(String input) {
        hasValue(input);
        isNumeric(input);
    }

    /**
     * 당첨 번호 입력
     */
    public List<Integer> readLottoWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        String input = readLine().trim();
        return validateWinningNumber(input);
    }

    public List<Integer> validateWinningNumber(String input) {
        hasValue(input);
        return convertStringToList(input);
    }
    public List<Integer> convertStringToList(String str) {
        String[] strArr = str.split(",");
        validateNumericArray(strArr);

        return convertArrayToList(strArr);
    }

    public void validateNumericArray(String[] strArr) {
        for (String s : strArr) {
            isNumeric(s);
        }
    }

    public List<Integer> convertArrayToList(String[] strArr) {
        return Arrays.stream(strArr).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * 보너스 번호 입력
     */
    public int getLottoBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = readLine().trim();
        validateBonusNumber(input);
        return convert(input);
    }

    public void validateBonusNumber(String input) {
        hasValue(input);
        isNumeric(input);
    }
}
