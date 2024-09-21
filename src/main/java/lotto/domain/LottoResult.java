package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    HashMap<Rank, Integer> lottoResult = new HashMap<>();

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public LottoResult() {
        initLottoResult();
    }

    public void initLottoResult() {

        lottoResult.put(Rank.FIRST, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.MISS, 0);
    }

    public void calculateLottoResult(List<Lotto> lottoList, Winning winning) {

        for (Lotto lotto : lottoList) {
            Rank rank = winning.matchRank(lotto);
            int count = lottoResult.getOrDefault(rank, 0);
            count++;

            lottoResult.put(rank, count);
        }
    }
}