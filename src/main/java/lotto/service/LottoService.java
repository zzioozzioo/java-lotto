package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoService {

    public Lotto getRandomLottoNumber(User user) {
        user.setUserNumberList(pickUniqueNumbersInRange(1, 45, 6));
        sortList(user);
        return new Lotto(user.getUserNumberList());
    }

    public void sortList(User user) {
        List<Integer> sortedList = user.getUserNumberList().stream().sorted().collect(Collectors.toList());
        user.setUserNumberList(sortedList);
    }

    public void initLottoResult(User user) {
        user.getLottoResult().put(Rank.FIRST, 0);
        user.getLottoResult().put(Rank.SECOND, 0);
        user.getLottoResult().put(Rank.THIRD, 0);
        user.getLottoResult().put(Rank.FOURTH, 0);
        user.getLottoResult().put(Rank.FIFTH, 0);
        user.getLottoResult().put(Rank.NO_RANK_TWO, 0);
        user.getLottoResult().put(Rank.NO_RANK_ONE, 0);
        user.getLottoResult().put(Rank.NO_RANK_ZERO, 0);
    }
}
