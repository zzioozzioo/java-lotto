package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;
import lotto.domain.User;

import java.util.HashMap;
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
    // TODO: 메서드명 다시 고민해보기
    public void calculateLottoResult() {
        List<Integer> winningNumberList = winning.getWinningNumberList(); // 당첨 번호 리스트

        for (Lotto lotto : user.getPurchasedLotteries()) {
            int winningCount = calculateWinningCount(lotto, winningNumberList);

            Rank matchRank = determineRank(lotto, winningCount);

            updateLottoResult(matchRank);
        }
    }

    public int calculateWinningCount(Lotto lotto, List<Integer> winningNumberList) {
        long winningCount = lotto.getNumbers().stream()
                .filter(winningNumberList::contains)
                .count();
        return (int)winningCount;
    }

    private Rank determineRank(Lotto lotto, int winningCount) {
        Rank matchRank;

        if (winningCount == 5) {
            int bonusNumber = winning.getBonusNumber();

            if (lotto.getNumbers().contains(bonusNumber)) { // 5개 일치, 보너스 볼 일치
                matchRank = rank.SECOND;
                return matchRank;
            }
            matchRank = rank.THIRD;
            return matchRank;
        }
        matchRank = getRankByWinningCount(winningCount);
        return matchRank;
    }

    public Rank getRankByWinningCount(int winningCount) {

        for (Rank rank : Rank.values()) {
            if (rank.getCount() == winningCount) {
                return rank;
            }
        }
        return Rank.NO_RANK_ZERO;
    }

    private void updateLottoResult(Rank rank) {
        HashMap<Rank, Integer> lottoResult = user.getLottoResult();
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
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
