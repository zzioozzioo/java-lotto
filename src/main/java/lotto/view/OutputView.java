package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {


    public void printBuyHowManyLotto(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printUserLottoNumber(List<Integer> numbers) { // 완
        System.out.println(numbers);
    }

    public void printWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printWinningRank(HashMap<Rank, Integer> lottoResult) {

        System.out.println(Rank.FIFTH.getCount() + "개 일치 (" + Rank.FIFTH.getConvertPrize() + "원) - " + lottoResult.get(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getCount() + "개 일치 (" + Rank.FOURTH.getConvertPrize() + "원) - " + lottoResult.get(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getCount() + "개 일치 (" + Rank.THIRD.getConvertPrize() + "원) - " + lottoResult.get(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getCount() + "개 일치, 보너스 볼 일치 (" + Rank.SECOND.getConvertPrize() + "원) - " + lottoResult.get(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getCount() + "개 일치 (" + Rank.FIRST.getConvertPrize() + "원) - " + lottoResult.get(Rank.FIRST) + "개");
    }

    public void printRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
