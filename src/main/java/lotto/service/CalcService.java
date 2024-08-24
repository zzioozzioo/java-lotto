package lotto.service;

import lotto.domain.Rank;
import lotto.domain.Winning;
import lotto.domain.User;

import java.util.List;

public class CalcService {

    private User user;
    private Winning winning;
    private Rank rank;

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
        int winningCount = 0;
        for (int targetNum : user.getUserNumberList()) {
            if (winningNumberList.contains(targetNum)) {
                winningCount++;
            }
        }

        updateWinningCount(winningCount);
    }

    public void updateWinningCount(int winningCount) {
        // TODO: 당첨 내역에 업데이트 로직 구현
        // winningCount를 user.winningCountList에 업데이트하는 로직은 어디에 추가? 그냥 여기에?

        List<Integer> winningNumberList = winning.getWinningNumberList();
        List<Integer> winningCountList = user.getWinningCountList();

        if (winningCount == rank.FIFTH.getCount()) { // 3개 일치
            int num = winningCountList.get(0);
            winningCountList.set(0, num++);
            return;
        }
        if (winningCount == rank.FOURTH.getCount()) { // 4개 일치
            int num = winningCountList.get(1);
            winningCountList.set(1, num++);
            return;
        }
        if (winningCount == rank.THIRD.getCount()) { // 5개 일치
            if (!winningNumberList.contains(winning.getBonusNumber())) {
                int num = winningCountList.get(2);
                winningCountList.set(2, num++);
                return;
            }
        }
        if (winningCount == rank.SECOND.getCount()) { // 5개 일치, 보너스 볼 일치
            if (winningNumberList.contains(winning.getBonusNumber())) {
                int num = winningCountList.get(3);
                winningCountList.set(3, num++);
                return;
            }
        }
        if (winningCount == rank.FIRST.getCount()) { // 6개 일치
            int num = winningCountList.get(4);
            winningCountList.set(4, num++);
            return;
        }
        return;
    }

    /**
     * 수익률 계산 기능
     */
    public void caculateRateOfReturn() {
        int amount = user.getBuyAmount();

        double rateOfReturn = (double)amount / user.getWinnings();
        rateOfReturn = Math.round(rateOfReturn * 100) / 100.0;

        user.setRateOfReturn(rateOfReturn);
    }
}
