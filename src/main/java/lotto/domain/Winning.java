package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    // TODO: setter 말고 constructor 사용하도록 변경해보기

    private List<Integer> winningNumberList = new ArrayList<>();
    private int bonusNumber; // 새로 알게 된 점: final은 초기화가 필수인 듯

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public void setWinningNumberList(List<Integer> winningNumberList) {
        this.winningNumberList = winningNumberList;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

}
