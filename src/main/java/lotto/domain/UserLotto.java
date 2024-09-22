package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.util.Utility.sortLotto;

public class UserLotto {

    List<Lotto> allUserLotto = new ArrayList<>();


    public List<Lotto> getAllUserLotto() {
        return allUserLotto;
    }

    public void generateAllUserLotto(int quantity) {
        for (int i = 0; i < quantity; i++) {
            allUserLotto.add(generateOneUserLotto());
        }
    }

    public Lotto generateOneUserLotto() {
        Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
        return sortLotto(lotto);
    }

}
