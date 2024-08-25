package lotto.view;

import lotto.domain.Rank;
import lotto.domain.User;

import java.util.List;


public class DisplayMessage {


    public void displayBuyHowManyLotto(User user) {
        System.out.println();
        System.out.println(user.getLottoQuantity() + "개를 구매했습니다.");
    }

    public void displayUserLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void displayWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void displayWinningRank(User user) {

        System.out.println(Rank.FIFTH.getCount() + "개 일치 (" + Rank.FIFTH.getConvertPrize() + "원) - " + user.getLottoResult().get(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getCount() + "개 일치 (" + Rank.FOURTH.getConvertPrize() + "원) - " + user.getLottoResult().get(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getCount() + "개 일치 (" + Rank.THIRD.getConvertPrize() + "원) - " + user.getLottoResult().get(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getCount() + "개 일치, 보너스 볼 일치 (" + Rank.SECOND.getConvertPrize() + "원) - " + user.getLottoResult().get(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getCount() + "개 일치 (" + Rank.FIRST.getConvertPrize() + "원) - " + user.getLottoResult().get(Rank.FIRST) + "개");
    }

    public void displayRateOfReturn(User user) {
        System.out.println("총 수익률은 " + user.getRateOfReturn() + "%입니다.");
    }
}
