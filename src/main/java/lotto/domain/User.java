package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private long buyAmount;
    private int lottoQuantity;

    private long winnings;
    private double rateOfReturn;

    private List<Integer> userNumberList = new ArrayList<Integer>(); // 발행받은 로또 번호

    // 왜 final?
    private ArrayList<Lotto> purchasedLotteries = new ArrayList<>(); // 구매한 로또 전체 번호 저장된 리스트
    private HashMap<Rank, Integer> lottoResult = new HashMap<>(); // 일치 개수에 따른 당첨 개수 저장된 해시맵

    public User() {
    }

    public long getBuyAmount() {
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

    public long getWinnings() {
        return winnings;
    }

    public void setWinnings(long winnings) {
        this.winnings = winnings;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }

    public void setUserNumberList(List<Integer> userNumberList) {
        this.userNumberList = userNumberList;
    }

    public void buyLotto(Lotto lotto) {
        purchasedLotteries.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLotteries() {
        return purchasedLotteries;
    }

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

}
