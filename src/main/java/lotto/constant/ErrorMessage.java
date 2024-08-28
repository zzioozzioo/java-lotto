package lotto.constant;

public enum ErrorMessage {

    // TODO: 보너스 숫자 1개만 들어오는지 확인하는 로직 있는지 확인!!

    NOT_NUMERIC("COMMON", "[ERROR] 숫자를 입력해야 합니다."),
    NOT_CORRECT_LENGTH("WINNING", "[ERROR] 당첨 번호의 개수는 " + ConstNumber.LOTTO_NUM_LENGTH.getNum() + "개여야 합니다."),
    NOT_IN_RANGE_WINNING_NUM("WINNING",
            "[ERROR] 로또 번호는 " + ConstNumber.LOTTO_FIRST_NUM.getNum() + "부터 " + ConstNumber.LOTTO_LAST_NUM.getNum() + " 사이의 숫자여야 합니다."),
    DUPLICATED_WINNING_NUM("WINNING", "[ERROR] 로또 번호는 중복이 없어야 합니다."),
    NOT_IN_RANGE_INPUT_AMOUNT("AMOUNT",
            "[ERROR] 구입 금액은 " + ConstNumber.INPUT_AMOUNT_MIN.getNum() + "와 " + ConstNumber.INPUT_AMOUNT_MAX.getNum() + "사이여야 합니다."),
    HAS_CHANGE("AMOUNT", "[ERROR] " + ConstNumber.LOTTO_PRICE.getNum() +"원 단위로 입력하셔야 합니다.");

    private final String errorMessage;
    private final String category;


    ErrorMessage(String category, String errorMessage) {
        this.category = category;
        this.errorMessage = errorMessage;
    }

    public String getCategory() {
        return category;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
