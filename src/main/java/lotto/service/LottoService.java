package lotto.service;

import lotto.domain.InputAmount;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoService {

    /**
     * 로또 번호 랜덤 생성 기능
     */
    public Lotto getRandomLottoNumber() {
        Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
        return sortLotto(lotto);
    }

    /**
     * 로또 번호 오름차순 정렬 기능
     */
    public Lotto sortLotto(Lotto lotto) {
        return new Lotto(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
    }

    /**
     * 로또 수량 계산 기능
     */
    public int countHowManyLotto(InputAmount inputAmount) { // 완
        return inputAmount.calculateLottoQuantity();
    }

    /**
     * 당첨금 계산 기능
     */
    public double calculateWinnings(LottoResult lottoResult) {

        double winnings = 0;

        for (Map.Entry<Rank, Integer> entry : lottoResult.getLottoResult().entrySet()) {
            int count = entry.getValue();
            long prize = entry.getKey().getPrize();

            winnings += count * prize;
        }
        return winnings;
    }

    /**
     * 수익률 계산 기능
     */
    public String calculateRateOfReturn(double winnings, InputAmount inputAmount) {

        long amount = inputAmount.getTotalAmount();
        double rateOfReturn = (winnings / (double) amount) * 100;

        DecimalFormat df = new DecimalFormat("#,##0.##");

        return df.format(rateOfReturn);
    }
}
