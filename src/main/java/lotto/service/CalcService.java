package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;

// TODO: 계산 기능
public class CalcService {

    private User user;
    private Lotto lotto;

    public CalcService(User user) {
        this.user = user;
    }

    /**
     * 로또 수량 계산 기능
     */
    public void countHowManyLotto() {
        int amount = user.getBuyAmount();
        user.setLottoQuantity(amount / 1000);
    }


}
