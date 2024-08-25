package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;
import lotto.domain.User;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CalcService {
    // TODO: CalcService의 성격과 맞지 않는 메서드는 따로 빼기

    /**
     * 로또 수량 계산 기능
     */
    public void countHowManyLotto(User user) {
        long amount = user.getBuyAmount();
        user.setLottoQuantity((int)(amount / 1000));
    }

    /**
     * 당첨 내역 계산 기능
     */
    // TODO: 메서드명 다시 고민해보기
    public void calculateLottoResult(User user, Winning winning) {
        List<Integer> winningNumberList = winning.getWinningNumberList(); // 당첨 번호 리스트

        for (Lotto lotto : user.getPurchasedLotteries()) {
            int winningCount = calculateWinningCount(lotto, winningNumberList);

            Rank matchRank = determineRank(lotto, winning, winningCount);

            updateLottoResult(matchRank, user);
        }
    }

    public int calculateWinningCount(Lotto lotto, List<Integer> winningNumberList) {
        long winningCount = lotto.getNumbers().stream()
                .filter(winningNumberList::contains)
                .count();
        return (int)winningCount;
    }

    private Rank determineRank(Lotto lotto, Winning winning, int winningCount) {
        Rank matchRank;

        if (winningCount == 5) {
            int bonusNumber = winning.getBonusNumber();

            if (lotto.getNumbers().contains(bonusNumber)) { // 5개 일치, 보너스 볼 일치
                matchRank = Rank.SECOND;
                return matchRank;
            }
            matchRank = Rank.THIRD;
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

    private void updateLottoResult(Rank rank, User user) {
        HashMap<Rank, Integer> lottoResult = user.getLottoResult();
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }

    /**
     * 당첨금 계산 기능
     */
    public void calculateWinnings(User user) {
        long winnings = 0;
        Iterator<Map.Entry<Rank, Integer>> entries = user.getLottoResult().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Rank, Integer> entry = entries.next();
            int count = entry.getValue();
            long prize = entry.getKey().getPrize();

            winnings += count * prize;
        }
        user.setWinnings(winnings);
    }

    /**
     * 수익률 계산 기능
     */
    public void calculateRateOfReturn(User user) {
        long amount = user.getBuyAmount();

        double rateOfReturn = user.getWinnings() / (double)amount;

        // 소수점 둘째 자리까지 유지하기 위해 DecimalFormat 사용
        DecimalFormat df = new DecimalFormat("#.##");
        rateOfReturn = Double.parseDouble(df.format(rateOfReturn * 100));

        user.setRateOfReturn(rateOfReturn);
    }
}
