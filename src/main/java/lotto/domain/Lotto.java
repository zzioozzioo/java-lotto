package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    // TODO: final 제거 고민 - 당첨 번호가 불변이긴 한데,, 괜찮나?
    //  final로 지정하면 setter을 못 열어서 안 됨..

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
