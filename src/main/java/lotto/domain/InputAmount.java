package lotto.domain;

import lotto.constant.ConstNumber;
import lotto.exception.HasChangeException;
import lotto.exception.NotInRangeInputAmountException;

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
            throw new NotInRangeInputAmountException();
        }
    }

    public void hasChange(int amount) {
        if (amount % ConstNumber.LOTTO_PRICE.getNum() != 0) {
            throw new HasChangeException();
        }
    }

    public int calculateLottoQuantity() {
        return (int)(buyAmount / ConstNumber.LOTTO_PRICE.getNum());
    }

    public long getTotalAmount() {
        return buyAmount;
    }
}
