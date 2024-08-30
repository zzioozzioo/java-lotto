package lotto.domain;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;

public class InputAmount {

    private final long buyAmount;

    public InputAmount(int buyAmount) {
        validateInputAmount(buyAmount);
        this.buyAmount = buyAmount;
    }

    private void validateInputAmount(int buyAmount) {
        isInputAmountInRange(buyAmount);
        hasChange(buyAmount);
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

    public int calculateLottoQuantity() {
        return (int)(buyAmount / ConstNumber.LOTTO_PRICE.getNum());
    }

    public long getTotalAmount() {
        return buyAmount;
    }
}
