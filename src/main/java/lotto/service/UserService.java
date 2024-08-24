package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

// 여기서 validation 호출?
// TODO: 사용자 로또 번호 생성 기능 구현
public class UserService {

    public Lotto getRandomNumber(User user) {
        user.setUserNumberList(pickUniqueNumbersInRange(1, 45, 6));
        sort(user);
        return new Lotto(user.getUserNumberList());
    }

    public void sort(User user) {
        Collections.sort(user.getUserNumberList());
    }
}
