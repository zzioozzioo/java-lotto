package lotto.domain;

public class User {

    private int buyAmount; // TODO: Long 타입 고민
    private int lottoQuantity;

    private int winnings;
    private double rateOfReturn;

    public User() {
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }

    public void setLottoQuantity(int lottoQuantity) {
        this.lottoQuantity = lottoQuantity;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    // TODO: 사용자 로또 번호 리스트를 어떻게 구현..? 구매한 개수만큼 리스트를 만들어야 하나..
    //  배열 안에 리스트 ArrayList<ST>[] userNumberList = new ArrayList[로또 수량]; 이런 식으로?
}
