package lotto.view;

import lotto.domain.Rank;
import lotto.domain.User;

import java.util.List;


public class DisplayResult {

    private Rank rank;
    private User user;

    public void displayBuyHowManyLotto() {
        System.out.println(user.getLottoQuantity() + "개를 구매했습니다.");
    }

    public void displayUserLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void displayWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void displayWinningRank() {

        // TODO: 일치 개수별 당첨 개수는 user에 저장해야 하나 rank에 저장해야 하나
        // user.lottoResult 해시맵에 저장!!
        System.out.println(rank.FIFTH.getCount() + "개 일치 (" + rank.FIFTH.getConvertPrize() + ") - " + user.getLottoResult().get(rank.FIFTH) + "개");
        System.out.println(rank.FOURTH.getCount() + "개 일치 (" + rank.FOURTH.getConvertPrize() + ") - " + user.getLottoResult().get(rank.FOURTH) + "개");
        System.out.println(rank.THIRD.getCount() + "개 일치 (" + rank.THIRD.getConvertPrize() + ") - " + user.getLottoResult().get(rank.THIRD) + "개");
        System.out.println(rank.SECOND.getCount() + "개 일치, 보너스 볼 일치 (" + rank.SECOND.getConvertPrize() + ") - " + user.getLottoResult().get(rank.SECOND) + "개");
        System.out.println(rank.FIRST.getCount() + "개 일치 (" + rank.FIRST.getConvertPrize() + ") - " + user.getLottoResult().get(rank.FIRST) + "개");
    }

    public void displayRateOfReturn() {
        System.out.println("총 수익률은 " + user.getRateOfReturn() + "%입니다.");
    }
}
