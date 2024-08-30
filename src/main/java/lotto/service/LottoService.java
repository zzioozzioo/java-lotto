package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.HashMap;
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

    public HashMap<Rank, Integer> initLottoResult() {
        HashMap<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.FIRST, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.MISS, 0);

        return lottoResult;
    }
}
