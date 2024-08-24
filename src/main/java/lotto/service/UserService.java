package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

// 여기서 validation 호출?
// TODO: 사용자 로또 번호 생성 기능 구현
public class UserService {

    private User user;

    public Lotto getRandomNumber() {
        user.setUserNumberList(pickUniqueNumbersInRange(1, 45, 6));
        sort();
        return new Lotto(user.getUserNumberList());
    }

    // 1. sort는 어떤 service에 포함시켜야 할지...
    // 2. UserService를 LottoService로 변경해야 하나?
    public void sort() {
        Collections.sort(user.getUserNumberList());
    }
}
