package lotto.domain;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        isCorrectLength(numbers);
        isWinningNumberInRange(numbers);
        isWinningNumberDuplicated(numbers);
    }

    public void isCorrectLength(List<Integer> list) {
        if (list.size() != ConstNumber.LOTTO_NUM_LENGTH.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_LENGTH.getErrorMessage());
        }
    }

    public void isWinningNumberInRange(List<Integer> list) {
        if (!list.stream().allMatch(digit -> digit >= ConstNumber.LOTTO_FIRST_NUM.getNum() && digit <= ConstNumber.LOTTO_LAST_NUM.getNum())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_WINNING_NUM.getErrorMessage());
        }
    }

    public void isWinningNumberDuplicated(List<Integer> list) {
        if (list.stream().distinct().count() != list.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUM.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        return (int)numbers.stream().filter(winningLotto::containNumber).count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    

}
