package lotto.constant;

public enum ConstNumber {
    LOTTO_NUM_LENGTH(6),
    LOTTO_FIRST_NUM(1),
    LOTTO_LAST_NUM(45),
    INPUT_AMOUNT_MIN(1000),
    INPUT_AMOUNT_MAX(100000),
    LOTTO_PRICE(1000);

    private final int num;

    ConstNumber(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
