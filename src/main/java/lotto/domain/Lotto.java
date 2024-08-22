package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    // TODO: final 제거 고민 - 당첨 번호가 불변이긴 한데,, 괜찮나?
    private final List<Integer> winningNumberList = new ArrayList<>();
    private final int bonusNumber = 0; // 새로 알게 된 점: final은 초기화가 필수인 듯
}
