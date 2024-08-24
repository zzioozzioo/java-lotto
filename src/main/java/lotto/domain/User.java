package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int buyAmount; // TODO: Long 타입 고민
    private int lottoQuantity;

    private int winnings;
    private double rateOfReturn;

    private List<Integer> userNumberList; // 발행받은 로또 번호
    private List<Integer> winningCountList = List.of(0, 0, 0, 0, 0); // 일치 개수별 당첨 개수(당첨 내역 출력에 필요)

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
    //  ㄴㄴ 리스트 하나만 만들어서 실시간으로 로또 수량만큼 [6개의 로또 번호 출력 + 당첨 내역에 업데이트] 반복


    public List<Integer> getUserNumberList() {
        return userNumberList;
    }

    public void setUserNumberList(List<Integer> userNumberList) {
        this.userNumberList = userNumberList;
    }

//    public void updateUserNumberList(List<Integer> userNumberList) {
//        this.userNumberList = userNumberList;
//    }

    public List<Integer> getWinningCountList() {
        return winningCountList;
    }

    public void setWinningCountList(List<Integer> winningCountList) {
        this.winningCountList = winningCountList;
    }
}
