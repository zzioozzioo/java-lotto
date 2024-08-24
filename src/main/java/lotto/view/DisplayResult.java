package lotto.view;

import lotto.domain.Rank;
import lotto.domain.User;


public class DisplayResult {

    private Rank rank;
    private User user;

    // TODO: 사용자 로또 번호 출력 기능 구현
    public void displayBuyHowManyLotto() {
        System.out.println(user.getLottoQuantity() + "개를 구매했습니다.");
    }

    public void displayWinningRank() {

        // TODO: 일치 개수별 당첨 개수는 user에 저장해야 하나 rank에 저장해야 하나
        System.out.println(rank.FIFTH.getCount() + "개 일치 (" + rank.FIFTH.getConvertPrize() + ") - " + "개");
        System.out.println(rank.FOURTH.getCount() + "개 일치 (" + rank.FOURTH.getConvertPrize() + ") - " + "개");
        System.out.println(rank.THIRD.getCount() + "개 일치 (" + rank.THIRD.getConvertPrize() + ") - " + "개");
        System.out.println(rank.SECOND.getCount() + "개 일치, 보너스 볼 일치 (" + rank.SECOND.getConvertPrize() + ") - " + "개");
        System.out.println(rank.FIRST.getCount() + "개 일치 (" + rank.FIRST.getConvertPrize() + ") - " + "개");
    }

    public void displayRateOfReturn() {
        System.out.println("총 수익률은 " + user.getRateOfReturn() + "%입니다.");
    }

}
