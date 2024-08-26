package lotto.domain;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;

public class InputAmount {

    private long buyAmount;

//    private int lottoQuantity;
//
//    private long winnings;
//    private double rateOfReturn;
//
//    private List<Integer> userNumberList = new ArrayList<>(); // 발행받은 로또 번호
//
//    // 왜 final?
//    private ArrayList<Lotto> purchasedLotteries = new ArrayList<>(); // 구매한 로또 전체 번호 저장된 리스트
//    private HashMap<Rank, Integer> lottoResult = new HashMap<>(); // 일치 개수에 따른 당첨 개수 저장된 해시맵

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
    // 1. 구입금액 입력받기 -> view
    // 2. 입력된 금액이 유효한지 확인
    // 3. 유효하다면 수량 계산, 그렇지 않다면 예외 내뿜기 -> service에서
    // 4. 수량만큼 반복해 번호 생성 -> Lotto에서
    // 5. 번호 저장 -> controller에서(?)

    // 필요한 핵심 도메인 로직
    // 1. 입력된 금액이 유효한지 확인
    // -> 그러면 이름을 User 대신 InputAmount로 해야 하나? oo


//    public long getBuyAmount() {
//        return buyAmount;
//    }
//
//    public void setBuyAmount(int buyAmount) {
//        this.buyAmount = buyAmount;
//    }
//
//    public int getLottoQuantity() {
//        return lottoQuantity;
//    }
//
//    public void setLottoQuantity(int lottoQuantity) {
//        this.lottoQuantity = lottoQuantity;
//    }
//
//    public long getWinnings() {
//        return winnings;
//    }
//
//    public void setWinnings(long winnings) {
//        this.winnings = winnings;
//    }
//
//    public double getRateOfReturn() {
//        return rateOfReturn;
//    }
//
//    public void setRateOfReturn(double rateOfReturn) {
//        this.rateOfReturn = rateOfReturn;
//    }
//
//    public List<Integer> getUserNumberList() {
//        return userNumberList;
//    }
//
//    public void setUserNumberList(List<Integer> userNumberList) {
//        this.userNumberList = userNumberList;
//    }
//
//    public void buyLotto(Lotto lotto) {
//        purchasedLotteries.add(lotto);
//    }
//
//    public ArrayList<Lotto> getPurchasedLotteries() {
//        return purchasedLotteries;
//    }
//
//    public HashMap<Rank, Integer> getLottoResult() {
//        return lottoResult;
//    }



}
