package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;
import lotto.domain.InputAmount;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CalcService {

    /**
     * 로또 수량 계산 기능
     */
    public int countHowManyLotto(InputAmount inputAmount) { // 완
        return inputAmount.calculateLottoQuantity();
    }

    /**
     * 당첨 내역 계산 기능
     */
    public HashMap<Rank, Integer> calculateLottoResult(HashMap<Rank, Integer> lottoResult, List<Lotto> lottoList, Winning winning) {

        for (Lotto lotto : lottoList) {
            Rank rank = winning.match(lotto);
            int count = lottoResult.getOrDefault(rank, 0);
            count++;

            lottoResult.put(rank, count);
        }

        return lottoResult;
    }

    /**
     * 당첨금 계산 기능
     */
    public double calculateWinnings(HashMap<Rank, Integer> lottoResult) {

        double winnings = 0;
        Iterator<Map.Entry<Rank, Integer>> entries = lottoResult.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Rank, Integer> entry = entries.next();
            int count = entry.getValue();
            long prize = entry.getKey().getPrize();

            winnings += count * prize;
        }
        return winnings;
    }

    /**
     * 수익률 계산 기능
     */
    public String calculateRateOfReturn(double winnings, InputAmount inputAmount) {

        long amount = inputAmount.getTotalAmount();
        double rateOfReturn = (winnings / (double) amount) * 100;

        DecimalFormat df = new DecimalFormat("#,##0.##");

        return df.format(rateOfReturn);
    }
}
