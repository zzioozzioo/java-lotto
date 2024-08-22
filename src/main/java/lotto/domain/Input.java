package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String buyAmount;

    // 변경 전 당첨 번호, 보너스 숫자
    private String winningNumber;
    private String bonusNumberString;

    // 변경 후 당첨 번호, 보너스 숫자
    private List<Integer> winningNumberList = new ArrayList<>(6);

    private int bonusNumber;

    public Input() {
    }

    public String getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(String buyAmount) {
        this.buyAmount = buyAmount;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(String winningNumber) {
        this.winningNumber = winningNumber;
    }

    public String getBonusNumberString() {
        return bonusNumberString;
    }

    public void setBonusNumberString(String bonusNumberString) {
        this.bonusNumberString = bonusNumberString;
    }

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
