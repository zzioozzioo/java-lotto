package lotto.service;

import lotto.domain.User;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

// 여기서 validation 호출?
// TODO: 사용자 로또 번호 생성 기능 구현
public class UserService {

    private User user;

    public void getRandomNumber() {
        user.setUserNumberList(pickUniqueNumbersInRange(1, 45, 6));
        // 중복 체크는 함수 내에서 다 하나? 그런 듯...
    }
}
