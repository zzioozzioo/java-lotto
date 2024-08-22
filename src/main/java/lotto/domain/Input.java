package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String buyAmount;

    private String winningNumber;
    private String bonusNumber;

    List<Integer> winningNumberList = new ArrayList<>(6);

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

    public String getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public void setWinningNumberList(List<Integer> winningNumberList) {
        this.winningNumberList = winningNumberList;
    }

}
