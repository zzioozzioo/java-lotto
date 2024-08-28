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
        isBonusNumberDuplicate(lotto, bonusNumber);
    }

    private void isBonusNumberInRange(int num) {
        if (num < ConstNumber.LOTTO_FIRST_NUM.getNum() || num > ConstNumber.LOTTO_LAST_NUM.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_WINNING_NUM.getErrorMessage());
        }
    }

    public void isBonusNumberDuplicate(Lotto lotto, int num) {
        if (lotto.getNumbers().contains(num)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUM.getErrorMessage());
        }
    }

    public Rank match(Lotto lottoNumber) {
        int count = lottoNumber.countMatch(lotto);
        boolean bonus = lottoNumber.containNumber(bonusNumber);
        return Rank.determineRank(count, bonus);
    }

    // 당첨 번호 입력받을 때 필요한 동작
    // 1.

    // 당첨 결과 생성에 필요한 동작
    // 1. 당첨 번호와 사용자 구매 랜덤 번호 비교 -> service?
    // 2. 일치 개수 계산 -> service
    // 3. 일치 개수에 따른 rank 결정
    // 4. 일치 개수별 결과 저장 -> controller

    // 필요한 핵심 도메인 로직
    // 1. 일치 개수에 따른 rank 결정
    // return Rank,,,


//    public List<Integer> getWinningNumberList() {
//        return winningNumberList;
//    }
//
//    public void setWinningNumberList(List<Integer> winningNumberList) {
//        this.winningNumberList = winningNumberList;
//    }
//
//    public int getBonusNumber() {
//        return bonusNumber;
//    }
//
//    public void setBonusNumber(int bonusNumber) {
//        this.bonusNumber = bonusNumber;
//    }

}
