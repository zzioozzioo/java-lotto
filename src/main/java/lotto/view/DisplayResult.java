package lotto.view;

import lotto.domain.Rank;
import lotto.domain.User;

import java.util.Collections;
import java.util.List;

public class DisplayResult {

    private User user;
    private Rank rank;

    // TODO: 사용자 로또 번호 출력 기능 구현
    public void displayUserNumber() {

    }

    // TODO: 당첨 내역 출력 기능
    public void displayWinningState() {
        List<Integer> rankList = rank.getRankList();
        Collections.sort(rankList);

        int index = 4;
        int num = 3;
        System.out.println(num + "개 일치 (5,000원) - " + rankList.get(index) + "개");
        System.out.println(++num + "개 일치 (50,000원) - " + rankList.get(--index) + "개");
        System.out.println(++num + "개 일치 (1,500,000원) - " + rankList.get(--index) + "개");
        System.out.println(num + "개 일치, 보너스 볼 일치 (30,000,000원) - " + rankList.get(--index) + "개");
        System.out.println(++num + "개 일치 (2,000,000,000원) - " + rankList.get(--index) + "개");

    }

    // TODO: 수익률 출력 기능
    public void displayRateOfReturn() {
    }

}
