package lotto.service;

import lotto.domain.Lotto;

import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoService {

    public Lotto getRandomLottoNumber() {
        Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
        return sortLotto(lotto);
    }

    public Lotto sortLotto(Lotto lotto) {
        return new Lotto(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
    }
}
