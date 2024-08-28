package lotto.domain;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;

public class InputAmount {

    private final long buyAmount;

    public long getBuyAmount() {
        return buyAmount;
    }

    public InputAmount(int buyAmount) {
        validate(buyAmount);
        this.buyAmount = buyAmount;
    }

    private void validate(int buyAmount) {
        validateInputAmount(buyAmount);
        isInputAmountInRange(buyAmount);
        hasChange(buyAmount);
    }

    public void validateInputAmount(int amount) {
        isInputAmountInRange(amount);
        hasChange(amount);
    }

    private void isInputAmountInRange(int amount) {
        if (amount < ConstNumber.INPUT_AMOUNT_MIN.getNum() || amount > ConstNumber.INPUT_AMOUNT_MAX.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_INPUT_AMOUNT.getErrorMessage());
        }
    }

    public void hasChange(int amount) {
        if (amount % ConstNumber.LOTTO_PRICE.getNum() != 0) {
            throw new IllegalArgumentException(ErrorMessage.HAS_CHANGE.getErrorMessage());
        }
    }

    // 사용자가 구매한 로또 번호 생성에 필요한 동작
    // 1. 구입금액 입력받기 -> view에서 메시지 출력, service에서 입력받기
    // 2. 입력된 금액이 유효한지 확인
    // 3. 유효하다면 수량 계산 -> service에서, 그렇지 않다면 예외 내뿜기 -> 여기서
    // 4. 수량만큼 반복(controller)해 번호 생성 -> Lotto에서
    // 5. 번호 저장 -> controller에서(?)

    // 필요한 핵심 도메인 로직
    // 1. 입력된 금액이 유효한지 확인
    // -> 그러면 이름을 User 대신 InputAmount로 해야 하나? oo

}
