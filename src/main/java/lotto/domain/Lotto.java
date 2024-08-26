package lotto.domain;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;
import lotto.validation.Validator;

import java.util.List;

import static java.util.Arrays.stream;

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

    // TODO: 추가 기능 구현

    // [로또 번호 생성에 필요한 동작]
    // 1. 랜덤 숫자 생성 -> service
    // 2. 숫자가 유효한지 확인
    // 3. 유효하다면 정렬 후 생성된 숫자를 저장하고, 그렇지 않다면 에러 내뿜기 -> controller(?)

    // 필요한 핵심 도메인 로직
    // 1. 숫자가 유효한지 확인
    // -> 유효성 검사를 하는 validate 코드를 이 클래스로 옮기기

    // [일치 개수 확인에 필요한 동작]
    // 1. 당첨 번호 리스트와 현재 번호 리스트(numbers) 비교 후 일치하는지 확인
    // 2. 보너스 번호도 일치하는지 확인

    // 필요한 핵심 도메인 로직
    // 1, 2 둘 다!!

}
