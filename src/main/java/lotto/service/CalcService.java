package lotto.service;

import lotto.domain.Winning;
import lotto.domain.User;

import java.util.List;

// TODO: 계산 기능
public class CalcService {

    private User user;
    private Winning winning;

    public CalcService(User user) {
        this.user = user;
    }

    /**
     * 로또 수량 계산 기능
     */
    public void countHowManyLotto() {
        int amount = user.getBuyAmount();
        user.setLottoQuantity(amount / 1000);
    }

    /**
     * 당첨 내역 계산 기능
     */
    public void calculateWinning() {
        List<Integer> winningNumberList = winning.getWinningNumberList();
        // TODO: 로또 번호 리스트와 당첨 번호 비교 로직 구현
    }

    /**
     * 수익률 계산 기능
     */
    public void caculateRateOfReturn() {
        int amount = user.getBuyAmount();
        // TODO: 소수점 둘째 자리에서 반올림
        double rateOfReturn = (double)amount / user.getWinnings();
    }

}
