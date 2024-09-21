package lotto.domain;

import lotto.constant.ConstNumber;
import lotto.constant.ErrorMessage;

public class Winning {

    private final Lotto lotto;
    private final int bonusNumber;

    public Winning(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(Lotto lotto, int bonusNumber) {
        isBonusNumberInRange(bonusNumber);
        isBonusNumberDuplicated(lotto, bonusNumber);
    }

    private void isBonusNumberInRange(int num) {
        if (num < ConstNumber.LOTTO_FIRST_NUM.getNum() || num > ConstNumber.LOTTO_LAST_NUM.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_WINNING_NUM.getErrorMessage());
        }
    }

    public void isBonusNumberDuplicated(Lotto lotto, int num) {
        if (lotto.containNumber(num)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUM.getErrorMessage());
        }
    }

    public Rank matchRank(Lotto userLottoNumbers) {
        int count = userLottoNumbers.matchCount(lotto);
        boolean bonus = userLottoNumbers.containNumber(bonusNumber);
        return Rank.determineRank(count, bonus);
    }

}
