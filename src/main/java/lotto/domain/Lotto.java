package lotto.domain;

import lotto.validation.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Validator validator = new Validator();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validator.validateWinningNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
